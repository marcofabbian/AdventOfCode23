package day11

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class GalaxyBrowseTests {
    @Test
    fun `should expand with 1u expansion degree`(){
        testAndAssert(listOf<String>(
            "...#......",
            ".......#..",
            "#.........",
            "..........",
            "......#...",
            ".#........",
            ".........#",
            "..........",
            ".......#..",
            "#...#....."), 2u,374u)
    }

    @Test
    fun `should expand with 10 expansion degree`(){
        testAndAssert(listOf<String>(
            "...#......", //0
            ".......#..", //1
            "#.........", //2
            "..........", //3
            "......#...", //4
            ".#........", //5
            ".........#", //6
            "..........", //7
            ".......#..", //8
            "#...#....."),//9
            10u,1030u)
    }

    @Test
    fun `should expand with 100 expansion degree`(){
        testAndAssert(listOf<String>(
            "...#......",
            ".......#..",
            "#.........",
            "..........",
            "......#...",
            ".#........",
            ".........#",
            "..........",
            ".......#..",
            "#...#....."), 100u,8410u)
    }

    @Test
    fun `should expand with 1 expansion degree with data from file`(){
        var pipe = mutableListOf<String>()
        File("src/test/resources/testdata_day11.csv").forEachLine {
            pipe.add(it)
        }
        testAndAssert(pipe, 2u, 10422930u)
    }

    @Test
    fun `should expand with 1000000 expansion degree with data from file`(){
        var pipe = mutableListOf<String>()
        File("src/test/resources/testdata_day11.csv").forEachLine {
            pipe.add(it)
        }
        testAndAssert(pipe, 1000000u, 699909023130u)
    }

    private fun testAndAssert(matrix: List<String>, expansion:ULong, expected: ULong) {
        val galaxy = Galaxy(getMatrix(matrix), expansion)
        val actual = galaxy.expand().assignName().calculate()
        assertEquals(expected, actual)
    }

    private fun getMatrix(matrix: List<String>): MutableList<MutableList<String>> {
        return matrix.map {
            it.split("").filter { it != "" }.map { it }.toMutableList()
        }.toMutableList()
    }

}