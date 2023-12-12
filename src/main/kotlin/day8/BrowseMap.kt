package day8

class BrowseMap(private val ways:Array<Way>, private val nodes:Array<Node>) {

    // initialStep = "AAA"
    // finalStep = "ZZZ"


    fun calculateSteps(forGhosts:Boolean = false):Int {
        return nextStep(0, findFirstSteps(forGhosts), 0)
    }

    private tailrec fun nextStep(index: Int, steps: Array<String>, count:Int): Int {
        if(checkAllSteps(steps)) {
            return count
        } else {
            when (ways[index].direction) {
                Direction.L -> {
                    val nextSteps = nodes.filter { it.key in steps }.map { it.left }.toTypedArray()
                    return nextStep(if(index == ways.size-1) 0 else  index+1, nextSteps, count+1)
                }
                Direction.R -> {
                    val nextSteps = nodes.filter { it.key in steps }.map { it.right }.toTypedArray()
                    return nextStep(if(index == ways.size-1) 0 else  index+1, nextSteps, count+1)
                }
            }
        }
    }

    private fun checkAllSteps(steps:Array<String>): Boolean {
        return steps.filter { it[2] == 'Z' }.size == steps.size
    }

    private fun findFirstSteps(forGhosts: Boolean):Array<String>{
        if(forGhosts)
            return nodes.filter { it.key[2] == 'A' && it.key != "AAA" }.map{ it.key }.toTypedArray()

        return nodes.filter { it.key[2] == 'A' }.map{ it.key }.toTypedArray()
    }
}