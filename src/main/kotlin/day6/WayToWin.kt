package day6

class WayToWin {
    fun SolveThePuzzle(race:List<RaceMatrix>) : Int {
        var result:Int = 1
        race.forEach {
            result *= calculate(it.time,it.distance)
        }
        return result
    }
    private fun calculate(time:Int, distance:Int) : Int {
        return (time-1 downTo 1 step 1).map {
            val travel = time - it
            ((travel * it))
        }.filter { it > distance }.size
    }
}