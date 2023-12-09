package day8

class BrowseMap(val maps:Maps) {

    val initialStep = "AAA"
    val finalStep = "ZZZ"

    fun calculateSteps():Int {
        var step = initialStep
        var index:Int = 0
        var count:Int = 0
        
        return nextStep(index, step, count)

    }

    private tailrec fun nextStep(index: Int, step: String, count:Int): Int {
        if(step == finalStep)
            return count
        else {
            when (this.maps.way[index].direction) {
                Direction.L -> {
                    val newStep = this.maps.nodes.filter { it.key==step }.single().left
                    return nextStep(if(index == this.maps.way.size-1) 0 else  index+1, newStep, count+1)
                }
                Direction.R -> {
                    val newStep = this.maps.nodes.filter { it.key==step }.single().right
                    return nextStep(if(index == this.maps.way.size-1) 0 else  index+1, newStep, count+1)
                }
            }
        }
    }
}