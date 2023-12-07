package day6

class WayToWin {
    fun SolveThePuzzle(race:List<RaceMatrix>) : ULong {
        var result:ULong = 1u
        race.forEach {
            result *= calculatev2(it.time,it.distance)
        }
        return result
    }
    private fun calculate(time:ULong, distance:ULong) : ULong {
        return (time-1u downTo 1u step 1).map {
            val travel = time - it
            ((travel * it))
        }.filter { it > distance }.size.toULong()
    }

    private fun calculatev2(time:ULong, distance:ULong) : ULong {
        var count:ULong = 0u
        (time-1u downTo 1u step 1).forEach {
            val travel = time - it

            if ((travel * it) > distance)
                count++
        }
        return count
    }
}