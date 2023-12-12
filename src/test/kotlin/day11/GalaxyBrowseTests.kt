package day11

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class GalaxyBrowseTests {
    @Test
    fun `should expand correctly`(){
        val expected:UInt = 374u
        val matrix = listOf<String>(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#.....")
        val galaxy = Galaxy(getMatrix(matrix))

        val actual = galaxy.expand().assignName().calculate()
        assertEquals(expected, actual)
    }

    @Test
    fun `should assign number correctly`(){
        val expected:UInt = 4125021078u
        var pipe = mutableListOf<String>()
        File("src/test/resources/testdata_day11.csv").forEachLine {
            pipe.add(it)
        }
        val galaxy = Galaxy(getMatrix(pipe))

        val actual = galaxy.expand().assignName().calculate()
        assertEquals(expected, actual)
    }

    private fun getMatrix(matrix: List<String>): MutableList<MutableList<String>> {
        return matrix.map {
            it.split("").filter { it != "" }.map { it }.toMutableList()
        }.toMutableList()
    }

}