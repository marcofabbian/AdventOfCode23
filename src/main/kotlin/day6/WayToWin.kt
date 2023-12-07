package day6

class WayToWin {
    fun SolveThePuzzle(race:List<RaceMatrix>) : ULong {
        var result:ULong = 1u
        race.forEach {
            result *= calculatev2(it.time,it.distance, it.startingPoint)
        }
        return result
    }
    private fun calculate(time:ULong, distance:ULong, startingPoint:ULong) : ULong {
        return (time-startingPoint downTo startingPoint step 1).map {
            val travel = time - it
            ((travel * it))
        }.filter { it > distance }.size.toULong()
    }

    private fun calculatev2(time:ULong, distance:ULong, startingPoint:ULong) : ULong {
        var count:ULong = 0u
        (time-startingPoint downTo startingPoint step 1).forEach {
            val travel = time - it
            
            if ((travel * it) > distance)
                count++
        }
        return count
    }
}