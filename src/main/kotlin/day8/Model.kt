package day8

enum class Direction {
    L,
    R
}
class Way(val direction:Direction) {}

class Node(val key:String, val left:String, val right:String) {
}

class Maps(val way:Array<Way>, val nodes:Array<Node>){

}