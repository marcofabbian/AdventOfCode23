package day7

import java.util.Enumeration

enum class HandType(val weight:Int) {
    FiveOfAKind(7),
    FourOfAKind(6),
    FullHouse(5),
    ThreeOfAKind(4),
    TwoPair(3),
    OnePair(2),
    HighCard(1);
}
enum class Card(val weight:Int = 0) {
    A(13),
    K(12),
    Q(11),
    J(10),
    T(9),
    `9`(8),
    `8`(7),
    `7`(6),
    `6`(5),
    `5`(4),
    `4`(3),
    `3`(2),
    `2`(1);
}

class Hand(val c1:Card, val c2:Card, val c3:Card, val c4:Card, val c5:Card, val bid:ULong)
{

    lateinit var handType:HandType

    init {
        val cards = mutableListOf<Card>()
        cards.apply {
            add(c1)
            add(c2)
            add(c3)
            add(c4)
            add(c5)
        }
        var typeCalculation = Card.entries.map { singleCardToSearch ->
            val appearance: Int = cards.filter {
                (it == singleCardToSearch)
            }.size

            Pair(singleCardToSearch, appearance)
        }.filter { it.second >= 1 }.sortedByDescending { it.second }


        when (typeCalculation.size) {
            1 -> handType= HandType.FiveOfAKind
            2 -> {
                if (typeCalculation[0].second == 4)
                    handType= HandType.FourOfAKind
                else
                    handType= HandType.FullHouse
            }

            3 -> {
                if (typeCalculation[0].second == 3)
                    handType= HandType.ThreeOfAKind
                else
                    handType= HandType.TwoPair
            }

            4 -> handType= HandType.OnePair
            else -> handType= HandType.HighCard
        }
    }
}

