package day10

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class PipeNetworkTests {


    @Test
    fun `should be able to calculate farthest point use case 1`() {
        testAndAssert(
            arrayOf<String>(
                ".....",
                ".S-7.",
                ".|.|.",
                ".L-J.",
                "....."
            ), 4)
    }

    @Test
    fun `should be able to calculate farthest point use case 2`() {
        testAndAssert(
            arrayOf<String>(
                "-L|F7",
                "7S-7|",
                "L|7||",
                "-L-J|",
                "L|-JF"
            ), 4)
    }

    @Test
    fun `should be able to calculate farthest point use case 3`() {
        testAndAssert(
            arrayOf<String>(
                "..F7.",
                ".FJ|.",
                "SJ.L7",
                "|F--J",
                "LJ..."
            ), 8)
    }

    @Test
    fun `should be able to calculate farthest point first use case`() {
        var pipe = mutableListOf<String>()
        File("src/test/resources/testdata_day10.csv").forEachLine {
            pipe.add(it)
        }
        testAndAssert(pipe.toTypedArray(), 11)
    }

    private fun testAndAssert(pipe: Array<String>, expected: Int) {
        val network = PipeLoop(getMatrix(pipe))
        val actual = network.calculateFarthest()
        assertEquals(expected, actual)
    }

    private fun getMatrix(matrix: Array<String>): Array<Array<String>> {
        return matrix.map { line ->
            line.split("").map {
                it
            }.filter { it != "" }.toTypedArray()
        }.toTypedArray()
    }

}