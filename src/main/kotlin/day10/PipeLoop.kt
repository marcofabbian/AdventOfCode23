package day10

enum class PipeElement(val value:String) {
    Pipe("|"),
    Hyphen("-"),
    L("L"),
    J("J"),
    Seven("7"),
    F("F"),
    Dot("."),
    S("S")
}
enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

fun Direction.canMove(r: Int, c:Int, data:Array<Array<String>>, previousPositions:MutableList<Triple<Int,Int,String>>): Boolean {
    var rlimit:Int = 0
    var cLimit:Int = 0

    when (this) {
        Direction.UP -> {
            val newPosition = (r - 1)
            rlimit = 0
            return (newPosition >= rlimit)
                    &&
                    data[newPosition][c] in listOf(PipeElement.Pipe.value, PipeElement.F.value, PipeElement.Seven.value)
                    &&
                    previousPositions.filter { it.first == newPosition && it.second == c }.isEmpty()
        }
        Direction.DOWN -> {
            val newPosition = (r + 1)
            rlimit = data.size
            return (newPosition < rlimit)
                    &&
                    data[newPosition][c] in listOf(PipeElement.Pipe.value, PipeElement.L.value, PipeElement.J.value)
                    &&
                    previousPositions.filter { it.first == newPosition && it.second == c }.isEmpty()
        }
        Direction.LEFT -> {
            val newPosition = (c -1)
            cLimit = 0
            return (newPosition >= cLimit)
                    &&
                    data[r][newPosition] in listOf(PipeElement.Hyphen.value, PipeElement.L.value, PipeElement.F.value)
                    &&
                    previousPositions.filter { it.first == r && it.second == newPosition }.isEmpty()
        }
        Direction.RIGHT -> {
            val newPosition = (c + 1)
            cLimit = data[r].size
            return (newPosition < cLimit)
                    &&
                    data[r][newPosition] in listOf(PipeElement.Hyphen.value, PipeElement.Seven.value, PipeElement.J.value)
                    &&
                    previousPositions.filter { it.first == r && it.second == newPosition }.isEmpty()
        }
        else -> throw Exception("Direction unknown")
    }
}
class PipeLoop(private val data:Array<Array<String>>) {

    fun calculateFarthest(): Int {
        return nextStep(mutableListOf<Triple<Int,Int,String>>(), mutableListOf(findStartingPoint()), 0)

    }

    private tailrec fun nextStep(previousPosition: MutableList<Triple<Int, Int, String>>, positions: MutableList<Triple<Int, Int, String>>, stepNumber: Int): Int {
        if (positions.size == 0) {
            return stepNumber-1
        } else {
            var newPositions = mutableListOf<Triple<Int, Int, String>>()
            var newPreviousPositions = positions

            positions.forEach { pos ->
                Direction.entries.forEach { dir ->
                    if (dir == Direction.UP && dir.canMove(pos.first, pos.second, data, previousPosition))
                        newPositions.add(Triple(pos.first - 1, pos.second, data[pos.first - 1][pos.second]))
                    else if (dir == Direction.DOWN && dir.canMove(pos.first, pos.second, data, previousPosition))
                        newPositions.add(Triple(pos.first + 1, pos.second, data[pos.first + 1][pos.second]))
                    else if (dir == Direction.LEFT && dir.canMove(pos.first, pos.second, data, previousPosition))
                        newPositions.add(Triple(pos.first, pos.second - 1, data[pos.first][pos.second-1]))
                    else if (dir == Direction.RIGHT && dir.canMove(pos.first, pos.second, data, previousPosition))
                        newPositions.add(Triple(pos.first, pos.second + 1, data[pos.first][pos.second+1]))
                }
            }
            return nextStep(newPreviousPositions, newPositions, stepNumber + 1)
        }
    }
    private fun isAtTheEnd(positions: Array<Triple<Int,Int,String>>): Boolean {
        return positions.filter { it.third == PipeElement.S.value }.size >= 1
    }

    fun findStartingPoint(): Triple<Int,Int,String> {
        var isBreaking = false
        var r: Int = 0
        var c: Int = 0
        for (i: Int in 0..data.size - 1) {
            for (j: Int in 0..data[i].size - 1) {
                if (data[i][j] == PipeElement.S.value) {
                    return Triple(i, j, "S")
                }
            }
        }
        throw Exception("Initial point issue")
    }

}