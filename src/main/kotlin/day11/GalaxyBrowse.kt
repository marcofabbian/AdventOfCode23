package day11

class GalaxyBrowse(private val galaxy:Galaxy) {
    fun calculateSumOfShortestPath():ULong{
        return galaxy
            .expand()
            .assignName()
            .calculate()
    }
}