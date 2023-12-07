import day6.RaceMatrix
import day6.WayToWin
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WaytoWinTests {

    @Test
    fun calculateSingleRace1(){
        var race = listOf(RaceMatrix(7u,9u, 1u))
        val expected:ULong = 4u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateSingleRace2(){
        var race = listOf(RaceMatrix(15u,40u, 1u))
        val expected:ULong = 8u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateSingleRace3(){
        var race = listOf(RaceMatrix(30u,200u, 1u))
        val expected:ULong = 9u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun firstExample(){
        var race = listOf(RaceMatrix(7u,9u, 1u),RaceMatrix(15u,40u, 1u),RaceMatrix(30u,200u, 1u))
        val expected:ULong = 288u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun finalSolution(){
        var race = listOf(RaceMatrix(47u,400u, 1u),RaceMatrix(98u,1213u, 1u),RaceMatrix(66u,1011u, 1u),RaceMatrix(98u,1540u, 1u))
        val expected:ULong = 1660968u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun finalSolutionPartTwo(){
        var race = listOf(RaceMatrix(71530u,940200u, 14u))
        val expected:ULong = 71503u //wrong value : 71512u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }
}