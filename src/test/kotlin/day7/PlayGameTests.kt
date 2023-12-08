package day7

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class PlayGameTests {

    @Test
    fun `Test single use case`(){
        val input:String = "32T3K"
        val bid:ULong = 765u
        val expectedResult:ULong = 765u
        val hand = createHand(input, bid)
        val gameResult = PlayGame().calculateWin(listOf(hand).toTypedArray())

        assertEquals(expectedResult, gameResult)
    }

    @Test
    fun `Test max of luck use case`(){
        val input:String = "JJJJJ"
        val bid:ULong = 765u
        val expectedResult:ULong = 765u
        val hand = createHand(input, bid)
        val gameResult = PlayGame().calculateWin(listOf(hand).toTypedArray())

        assertEquals(expectedResult, gameResult)
    }

    @Test
    fun `Test 3J use case`(){
        val input:String = "JJJQK"
        val bid:ULong = 765u
        val expectedResult:ULong = 765u
        val hand = createHand(input, bid)
        val gameResult = PlayGame().calculateWin(listOf(hand).toTypedArray())

        assertEquals(expectedResult, gameResult)
    }

    @Test
    fun `Test multiple use case`(){
        val expectedResult:ULong = 5905u
        val hands = mutableListOf<Hand>()
        hands.add(createHand("KTJJT", 220u))
        hands.add(createHand("KK677", 28u))
        hands.add(createHand("QQQJA", 483u))
        hands.add(createHand("32T3K", 765u))
        hands.add(createHand("T55J5", 684u))

        val gameResult = PlayGame().calculateWin(hands.toTypedArray())

        assertEquals(expectedResult, gameResult)
    }

    @Test
    fun `Test first part use case`(){
        val expectedResult:ULong = 252898370u
            //253019563u
            //252894314u wrong
        val hands = mutableListOf<Hand>()
        File("src/test/resources/testdata.csv").forEachLine {
            val raw = it.split(" ")
            hands.add(createHand(raw.first(), raw.last().toULong()))
        }

        val gameResult = PlayGame().calculateWin(hands.toTypedArray())

        assertEquals(expectedResult, gameResult)
    }

    private fun createHand(input:String, bid:ULong):Hand{
        return Hand(
            Card.valueOf(""+input[0]),
            Card.valueOf(""+input[1]),
            Card.valueOf(""+input[2]),
            Card.valueOf(""+input[3]),
            Card.valueOf(""+input[4]),
            bid)
    }
}