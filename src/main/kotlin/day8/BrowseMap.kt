package day8

import java.lang.Exception
import java.util.*

class BrowseMap(val ways:Array<Way>, val nodes:Array<Node>) {

    val initialStep = "AAA"
    val finalStep = "ZZZ"
    //var initialStepExp = "[0-9]*[A-Z]*[A]".toRegex()
    //var finalStepExp = "[0-9]*[A-Z]*[Z]".toRegex()


    fun calculateSteps():Int {
        var steps = findFirstStep()
        var index:Int = 0
        var count:Int = 0

        return nextStep(index, steps, count)
    }

    private tailrec fun nextStep(index: Int, steps: Array<String>, count:Int): Int {
        if(checkAllSteps(steps)) {
            return count
        } else {
            when (ways[index].direction) {
                Direction.L -> {
                    val newSteps = nodes.filter { it.key in steps }.map { it.left }.toTypedArray()
                    return nextStep(if(index == ways.size-1) 0 else  index+1, newSteps, count+1)
                }
                Direction.R -> {
                    val newSteps = nodes.filter { it.key in steps }.map { it.right }.toTypedArray()
                    return nextStep(if(index == ways.size-1) 0 else  index+1, newSteps, count+1)
                }
            }
        }
    }

    private fun checkAllSteps(steps:Array<String>): Boolean {
        //return steps.filter { finalStepExp.containsMatchIn(it) }.size == steps.size
        return steps.filter { it[2] == 'Z' }.size == steps.size
    }

    private fun findFirstStep():Array<String>{
        //return nodes.filter { (initialStepExp.containsMatchIn( it.key)) }.map{ it.key }.toTypedArray()
        return nodes.filter { it.key[2] == 'A' }.map{ it.key }.toTypedArray()
    }
}