package day9

class SandReport(val matrix:Array<LongArray>) {

    fun calculateExtraZero():Pair<Long,Long> {
        var endResult:Long = 0
        var startResult:Long = 0
        matrix.forEach {
            val calculatedMatrix = Matrix(mutableListOf(it.toMutableList()))
            .createMatrix()
            endResult += calculatedMatrix.calculateExtraZeroAtTheEnd()
            startResult += calculatedMatrix.calculateExtraZeroAtTheBeginning()
        }
        return Pair(startResult,endResult)
    }

}