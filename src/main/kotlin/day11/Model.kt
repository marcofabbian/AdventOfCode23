package day11

class Galaxy(private val data:MutableList<MutableList<String>>) {

    private var numberOfGalaxies = 1
    private var listOFPositions = mutableListOf<Triple<String, Int, Int>>()
    private var rowToexpand = mutableListOf<Int>()
    private var colToexpand = mutableListOf<Int>()

    private val growth:UInt = 1000000u
    fun expand():Galaxy{
        for(i in 0..<data.size-1) {
            if(data[i].filter { it == "#" }.isEmpty())
                rowToexpand.add(i)
        }

        for (i in 0..<data.first().size-1){
            if(isColumnEmpty(i))
                colToexpand.add(i)
        }
        return this
    }

    fun assignName():Galaxy{
        for(i in 0..data.size-1) {
            for(j in 0..data[i].size-1) {
                if (data[i][j] == "#") {
                    data[i][j] = numberOfGalaxies.toString()
                    listOFPositions.add(Triple(numberOfGalaxies.toString(),i,j))
                    numberOfGalaxies++
                }
            }
        }
        return this
    }

    private fun isColumnEmpty(column:Int): Boolean {
        for(i in 0..data.size-1) {
            if(data[i][column] != ".")
                return false
        }
        return true
    }

    fun calculate(): UInt {
        var listOfDistances:UInt = 0u
        for (i:Int in 0..listOFPositions.size-2) {
            for(j:Int in i + 1 .. listOFPositions.size-1) {
                var distance:UInt = 0u
                distance += Math.abs(Math.abs(listOFPositions[i].second) - Math.abs(listOFPositions[j].second)).toUInt()
                distance += Math.abs(Math.abs(listOFPositions[i].third) - Math.abs(listOFPositions[j].third)).toUInt()
                rowToexpand.forEach {
                    if (
                        (listOFPositions[i].second <= it && it <= listOFPositions[j].second)
                        ||
                        (listOFPositions[j].second <= it && it <= listOFPositions[i].second)
                    )
                        distance+=growth
                }

                colToexpand.forEach {
                    if (
                        (listOFPositions[i].third <= it && it <= listOFPositions[j].third)
                        ||
                        (listOFPositions[j].third <= it && it <= listOFPositions[i].third)
                    )
                        distance+=growth
                }
                listOfDistances += distance
            }
        }
        return listOfDistances
    }

}

fun MutableList<MutableList<String>>.addColumn(col:Int){
    this.forEach {line ->
        line.add(col,".")
    }
}