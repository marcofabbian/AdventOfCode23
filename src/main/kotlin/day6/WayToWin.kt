package day6

class WayToWin {
    fun SolveThePuzzle(race:List<RaceMatrix>) : ULong {
        var result:ULong = 1u
        race.forEach {
            result *= calculate(it.time,it.distance, it.startingPoint)
        }
        return result
    }
    private fun calculate(time:ULong, distance:ULong, startingPoint:ULong) : ULong {
        return (time-startingPoint downTo startingPoint step 1).map {
            val travel = time - it
            ((travel * it))
        }.filter { it > distance }.size.toULong()
    }
}