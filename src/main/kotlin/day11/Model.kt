package day11

import kotlin.math.abs

class Galaxy(private val data:MutableList<MutableList<String>>, private val expansion:ULong = 1u) {

    private var listOFPositions = mutableListOf<Triple<String, Int, Int>>()
    private var rowToExpand = mutableListOf<Int>()
    private var colToExpand = mutableListOf<Int>()

    fun expand():Galaxy{
        for(i in 0..< data.size) {
            if(data[i].filter { it == "#" }.isEmpty())
                rowToExpand.add(i)
        }

        for (i in 0 ..< data.first().size){
            if(isColumnEmpty(i))
                colToExpand.add(i)
        }
        return this
    }

    fun assignName():Galaxy{
        var numberOfGalaxies = 1
        for(i in 0..< data.size) {
            for(j in 0..< data[i].size) {
                if (data[i][j] == "#") {
                    listOFPositions.add(Triple(numberOfGalaxies.toString(),i,j))
                    numberOfGalaxies++
                }
            }
        }
        return this
    }

    private fun isColumnEmpty(column:Int): Boolean {
        for(i in 0..< data.size ) {
            if(data[i][column] != ".")
                return false
        }
        return true
    }

    fun calculate(): ULong {
        var sumOfDistances:ULong = 0u

        for (i:Int in 0..< listOFPositions.size-1) {

            for(j:Int in i + 1 ..< listOFPositions.size) {
                var distance:ULong = 0u
                distance += abs(abs(listOFPositions[i].second) - abs(listOFPositions[j].second)).toULong()
                distance += abs(abs(listOFPositions[i].third) - abs(listOFPositions[j].third)).toULong()

                var countExpansion = 0
                rowToExpand.forEach {
                    if (
                        (listOFPositions[i].second < it && it < listOFPositions[j].second)
                        ||
                        (listOFPositions[j].second < it && it < listOFPositions[i].second)
                    )
                        countExpansion++
                }
                if(countExpansion > 0) {
                    distance -= countExpansion.toULong()
                    distance = distance + (countExpansion.toULong() * expansion)
                }

                countExpansion = 0
                colToExpand.forEach {
                    if (
                        (listOFPositions[i].third < it && it < listOFPositions[j].third)
                        ||
                        (listOFPositions[j].third < it && it < listOFPositions[i].third)
                    )
                        countExpansion++
                }
                if(countExpansion > 0) {
                    distance -= countExpansion.toULong()
                    distance += (countExpansion.toULong() * expansion)
                }

                sumOfDistances += distance
            }
        }
        return sumOfDistances
    }

}