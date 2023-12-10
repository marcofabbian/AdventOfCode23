package day9

class SandReport(val matrix:Array<LongArray>) {

    fun calculateNextZeroValue():Long {
        var result:Long = 0
        matrix.forEach {
            result += Matrix(mutableListOf(it.toMutableList()))
                .createMatrix()
                .calculateExtraZero()
        }
        return result
    }
}