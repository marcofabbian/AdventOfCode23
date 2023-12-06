import day6.RaceMatrix
import day6.WayToWin
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WaytoWinTests {

    @Test
    fun calculateSingleRace1(){
        var race = listOf(RaceMatrix(7,9))
        val expected = 4
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateSingleRace2(){
        var race = listOf(RaceMatrix(15,40))
        val expected = 8
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateSingleRace3(){
        var race = listOf(RaceMatrix(30,200))
        val expected = 9
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun firstExample(){
        var race = listOf(RaceMatrix(7,9),RaceMatrix(15,40),RaceMatrix(30,200))
        val expected = 288
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun finalSolution(){
        var race = listOf(RaceMatrix(47,400),RaceMatrix(98,1213),RaceMatrix(66,1011),RaceMatrix(98,1540))
        val expected = 1660968
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }
}