package tetris.logic

import com.lowagie.text.Cell


abstract class Tetronimo {
    val struct : List[Point]
    val blockType : CellType
    def containsPoint(p : Point) : Boolean ={
        for(i <- struct){
            if(i == p) return true
        }
        return false
    }
    def rotateLeft : Tetronimo
    def rotateRight : Tetronimo
}
class ITetronimo(orientation : List[Point] = List(Point(-1,0),Point(0,0),Point(1,0),Point(2,0))) extends Tetronimo { 
    val struct : List[Point]= orientation
    val blockType : CellType = ICell
    def rotateRight: Tetronimo = {
        val newStruct = struct.map(p => Point(-p.y + 1, p.x))
        return new ITetronimo(newStruct)
    }
    def rotateLeft: Tetronimo = {
        val newStruct = struct.map(p => Point(p.y, -p.x + 1))
        return new ITetronimo(newStruct)
    }

}
class OTetronimo(orientation : List[Point] = List(Point(1,0),Point(0,0),Point(0,-1), Point(1,-1))) extends Tetronimo {
    val struct: List[Point]= orientation
    val blockType: CellType = OCell
    def rotateRight: Tetronimo = new OTetronimo
    def rotateLeft: Tetronimo =  new OTetronimo
}
class NormalTetronimo(i : Int, orientation : List[Point], block : CellType) extends Tetronimo {
    val struct : List[Point] = orientation
    val blockType: CellType = block
    def rotateRight: Tetronimo = {
        val newStruct = struct.map(p => Point(-p.y, p.x))
        return new NormalTetronimo(i, newStruct, block)
    }
    def rotateLeft: Tetronimo = {
        val newStruct = struct.map(p => Point(p.y, -p.x))
        return new NormalTetronimo(i, newStruct, block)
    }
}