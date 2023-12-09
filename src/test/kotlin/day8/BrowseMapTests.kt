package day8

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class BrowseMapTests {

    @Test
    fun `Test first use case`(){
        val expectedStepsNumber = 2
        val way = "RL"
        var ways = loadWays(way)

        val node =  arrayOf(
                    "AAA,BBB,CCC",
                    "BBB,DDD,EEE",
                    "CCC,ZZZ,GGG",
                    "DDD,DDD,DDD",
                    "EEE,EEE,EEE",
                    "GGG,GGG,GGG",
                    "ZZZ,ZZZ,ZZZ")
        var nodes = loadNodes(node)

        val maps = Maps(ways, nodes)
        val browser = BrowseMap(maps)
        val result = browser.calculateSteps()

        assertEquals(expectedStepsNumber,result)
    }

    @Test
    fun `Test fist part use case`(){
        val expectedStepsNumber = 11911
        var ways= mutableListOf<Way>()
        var nodes = mutableListOf<Node>()

        var index = 0
        File("src/test/resources/testdata_day8.csv").forEachLine { line ->
            if(index == 0) {
                ways.addAll(loadWays(line))
                index++
            } else {
                nodes.add(loadNode(line))
            }
        }

        val maps = Maps(ways.toTypedArray(), nodes.toTypedArray())
        val browser = BrowseMap(maps)

        val result = browser.calculateSteps()

        assertEquals(expectedStepsNumber,result)
    }

    private fun loadNodes(maps: Array<String>): Array<Node> {
        return maps.map {line ->
            val el = line.split(",")

            (Node(el[0].toString(), el[1].toString(), el[2].toString()))
        }.toTypedArray()
    }

    private fun loadNode(line:String): Node {
        val el = line.split(",")
        return Node(el[0].toString(), el[1].toString(), el[2].toString())
    }

    private fun loadWays(way: String): Array<Way> {
        return (way.split("").filter { it != "" }).map {

            (Way(Direction.valueOf(it)))
        }.toTypedArray()
    }
}