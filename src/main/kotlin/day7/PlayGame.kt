package day7

import java.math.BigDecimal

class PlayGame {
    fun calculateWin(hands:Array<Hand>):ULong {
        var result:ULong = 0u
        var orderedList = hands.sortedWith(getComparer())

        //orderedList.forEach {
        //    println(it.toString()+ " " + it.bid + " " + it.handType.toString())
        //}

        orderedList.forEachIndexed {index, element ->
            result += (element.bid * (index.toULong() + 1u))
        }

        return result
    }

    private fun getComparer():Comparator<Hand> {
        return Comparator<Hand> { a, b ->
            if(a.handType == b.handType){
                var diff1 = (a.c1.weight - b.c1.weight)
                var diff2 = (a.c2.weight - b.c2.weight)
                var diff3 = (a.c3.weight - b.c3.weight)
                var diff4 = (a.c4.weight - b.c4.weight)
                var diff5 = (a.c5.weight - b.c5.weight)

                if(diff1 != 0)  diff1
                else if(diff2 != 0)  diff2
                else if(diff3 != 0)  diff3
                else if(diff4 != 0)  diff4
                else if(diff5 != 0)  diff5
                else 0
            } else
                a.handType.weight - b.handType.weight
        }
    }
}