package tetris.logic

import com.lowagie.text.Cell


abstract class Tetronimo {
    val struct : List[Point]
    val blockType : CellType
    val allPieces : Map[Int,(List[Point],CellType)] = Map(
        0 -> (List(Point(-1,0),Point(0,0),Point(1,0),Point(2,0)),ICell),
        1 -> (List(Point(-1,1),Point(0,0),Point(-1,0),Point(1,0)),JCell),
        2 -> (List(Point(-1,0),Point(0,0),Point(1,0),Point(1,1)),LCell),
        3 -> (List(Point(-1,1),Point(-1,0),Point(0,0),Point(0,1)),OCell),
        4 -> (List(Point(-1,0),Point(0,0),Point(0,1),Point(1,1)),SCell),
        5 -> (List(Point(-1,0),Point(0,0),Point(0,1),Point(1,0)),TCell),
        6 -> (List(Point(-1,1),Point(0,0),Point(0,1),Point(1,0)),ZCell)
    ) 
    def containsPoint(p : Point) : Boolean ={
        for(i <- struct){
            if(i.sameAs(p)) return true
        }
        return false
    }
    def rotateLeft : Tetronimo
    def rotateRight : Tetronimo
}
class ITetronimo(orientation : List[Point] = List(Point(-1,0),Point(0,0),Point(1,0),Point(2,0))) extends Tetronimo { 
    val struct : List[Point]= orientation
    val blockType : CellType = allPieces(0)._2
    def rotateRight: Tetronimo = {
        val newStruct = struct.map(p => Point(-p.y + 1, p.x))
        return new ITetronimo(newStruct)
    }
    def rotateLeft: Tetronimo = {
        val newStruct = struct.map(p => Point(p.y, -p.x + 1))
        return new ITetronimo(newStruct)
    }

}
class OTetronimo(orientation : List[Point] = List(Point(-1,1),Point(-1,0),Point(0,0),Point(0,1))) extends Tetronimo {
    val struct: List[Point]= orientation
    val blockType: CellType =  allPieces(3)._2
    def rotateRight: Tetronimo = new OTetronimo
    def rotateLeft: Tetronimo =  new OTetronimo
}
class NormalTetronimo(i : Int, orientation : List[Point]) extends Tetronimo {
    val struct : List[Point] = orientation
    val blockType: CellType =  allPieces(i)._2
    def rotateRight: Tetronimo = {
        val newStruct = struct.map(p => Point(-p.y, p.x))
        return new NormalTetronimo(i, newStruct)
    }
    def rotateLeft: Tetronimo = {
        val newStruct = struct.map(p => Point(p.y, -p.x))
        return new NormalTetronimo(i, newStruct)
    }
}