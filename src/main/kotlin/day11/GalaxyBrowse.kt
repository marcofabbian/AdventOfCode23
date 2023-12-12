package day11

class GalaxyBrowse(private val galaxy:Galaxy) {
    fun calculateSumOfShortestPath():UInt{
        return galaxy
            .expand()
            .assignName()
            .calculate()
    }
}