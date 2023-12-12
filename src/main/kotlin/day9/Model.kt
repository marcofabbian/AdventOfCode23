package day9

data class Matrix(val data:MutableList<MutableList<Long>>) {
    fun createMatrix(): Matrix {
        var row = 0
        var diff:Long = 0
        var previous:Long = 0
        do {
            previous = data[row][0]
            var line = mutableListOf<Long>()
            for(col:Int in 1..data[row].size-1) {
                diff = data[row][col]- previous
                previous = data[row][col]
                line.add(diff)
            }
            data.add(line)
            row++
        } while(line.size != line.filter { it == 0L }.size)

        return this
    }

    fun calculateExtraZeroAtTheEnd():Long {
        var values = mutableListOf<Long>()
        val lastRow = data.size-1
        for(row:Int in lastRow downTo 0){
            val col = data[row].size-1
            when(row){
                lastRow -> {
                    values.add(0)
                }
                else -> {
                    val previousElement = values.last()
                    val calculated = data[row][col] + previousElement
                    values.add(calculated)
                }
            }
        }
        return values.last()
    }

    fun calculateExtraZeroAtTheBeginning():Long {
        var values = mutableListOf<Long>()
        val lastRow = data.size-1
        for(row:Int in lastRow downTo 0){
            val col = 0
            when(row){
                lastRow -> {
                    values.add(0)
                }
                else -> {
                    val previousElement = values.last()
                    val calculated = data[row][col] - previousElement
                    values.add(calculated)
                }
            }
        }
        return values.last()
    }
}