package day6

import day6.RaceMatrix
import day6.WayToWin
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WaytoWinTests {

    @Test
    fun calculateSingleRace1(){
        var race = listOf(RaceMatrix(7u,9u))
        val expected:ULong = 4u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateSingleRace2(){
        var race = listOf(RaceMatrix(15u,40u))
        val expected:ULong = 8u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun calculateSingleRace3(){
        var race = listOf(RaceMatrix(30u,200u))
        val expected:ULong = 9u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun firstExample(){
        var race = listOf(
            RaceMatrix(7u,9u),
            RaceMatrix(15u,40u),
            RaceMatrix(30u,200u))
        val expected:ULong = 288u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun finalSolution(){
        var race = listOf(
            RaceMatrix(47u,400u),
            RaceMatrix(98u,1213u),
            RaceMatrix(66u,1011u),
            RaceMatrix(98u,1540u))
        val expected:ULong = 1660968u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

    @Test
    fun finalSolutionPartTwo(){
        var race = listOf(RaceMatrix(47986698u,400121310111540u))
        val expected:ULong = 26499773u //wrong value : 71512u
        val target = WayToWin()
        val actual = target.SolveThePuzzle(race)
        assertEquals(expected, actual)
    }

}