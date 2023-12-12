package day9

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class SandReportTests {

    @Test
    fun `First use case`(){
        val expected:Long = 114
        val matrix = getMatrix(arrayOf<String>(
                    "0 3 6 9 12 15",
                    "1 3 6 10 15 21",
                    "10 13 16 21 30 45"))

        val results = SandReport(matrix).calculateExtraZero()

        assertEquals(expected, results.second)
    }

    @Test
    fun `Negative number use case`(){
        val expected:Long = -14
        val matrix = getMatrix(arrayOf<String>("7 6 5 4 3 2 1 0 -1 -2 -3 -4 -5 -6 -7 -8 -9 -10 -11 -12 -13"))

        val results = SandReport(matrix).calculateExtraZero()

        assertEquals(expected, results.second)
    }

    @Test
    fun `Big numbers use case`(){
        val expected:Long = 41955110
        val matrix = getMatrix(arrayOf<String>("18 43 89 169 300 508 853 1501 2897 6147 13824 31625 71718 159389 345977 733436 1519704 3080095 6109095 11860445 22542764"))

        val results = SandReport(matrix).calculateExtraZero()

        assertEquals(expected, results.second)
    }


    @Test
    fun `Test fist & second part use case`(){
        val atEnd:Long = 1877825184
        val atBeginning:Long = 1

        var list = mutableListOf<String>()
        File("src/test/resources/testdata_day9.csv").forEachLine {
            list.add(it)
        }
        val matrix = getMatrix(list.toTypedArray())
        val report = SandReport(matrix)

        val results = report.calculateExtraZero()

        assertEquals(atBeginning, results.first)
        assertEquals(atEnd, results.second)
    }

    private fun getMatrix(matrix: Array<String>): Array<LongArray> {
        return matrix.map {line ->
                (line.split(" ").map {
                    it.toLong()
                }.toLongArray())
            }.toTypedArray()
    }
}