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

        val browser = BrowseMap(ways, nodes)
        val result = browser.calculateSteps()

        assertEquals(expectedStepsNumber,result)
    }

    @Test
    fun `Test second use case`(){
        val expectedStepsNumber = 6
        val way = "LR"
        var ways = loadWays(way)

        val node =  arrayOf(
            "11A,11B,XXX",
            "11B,XXX,11Z",
            "11Z,11B,XXX",
            "22A,22B,XXX",
            "22B,22C,22C",
            "22C,22Z,22Z",
            "22Z,22B,22B",
            "XXX,XXX,XXX")
        var nodes = loadNodes(node)

        val browser = BrowseMap(ways, nodes)
        val result = browser.calculateSteps()

        assertEquals(expectedStepsNumber,result)
    }

    @Test
    fun `Test fist & second part use case`(){
        val expectedStepsNumber = 1
            //21883
            //11911
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

        val browser = BrowseMap(ways.toTypedArray(), nodes.toTypedArray())
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