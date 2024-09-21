package tetris.logic

// you can alter this file!

case class Point(x : Int, y : Int) {
    def sameAs(p : Point) : Boolean ={
        if(p.x == x && p.y == y){
            return true
        }
        else return false
    }
    def toTuple() : (Int,Int) = {
        (x,y)
    }
}
