package tetris.logic

import com.lowagie.text.Cell


abstract class Tetronimo{
    def cell : CellType
    def structure : List[Point] = List()
    def containsPoint(p : Point) : Boolean ={
        for(i <- structure){
            if(i.sameAs(p)) return true
        }
        return false
    }
}
case class IPiece() extends Tetronimo{
    override def cell : CellType = ICell
    override def structure : List[Point] = List(Point(-1,0),Point(0,0),Point(1,0),Point(2,0))   
}
case class JPiece() extends Tetronimo{
    override def cell : CellType = JCell
    override def structure : List[Point] = List(Point(-1,1),Point(0,0),Point(-1,0),Point(1,0))
}
case class LPiece() extends Tetronimo{
    override def cell : CellType = LCell
    override def structure : List[Point] = List(Point(-1,0),Point(0,0),Point(1,0),Point(1,1))
}
case class OPiece() extends Tetronimo{
    override def cell : CellType = OCell
    override def structure : List[Point] = List(Point(0,0),Point(0,1),Point(1,1),Point(1,0))
}
case class SPiece() extends  Tetronimo{
    override def cell : CellType = SCell
    override def structure : List[Point] = List(Point(-1,0),Point(0,0),Point(0,1),Point(1,1))
}
case class TPiece() extends  Tetronimo{
    override def cell : CellType = TCell
    override def structure : List[Point] = List(Point(-1,0),Point(0,0),Point(0,1),Point(1,0))
}
case class ZPiece() extends  Tetronimo{
    override def cell : CellType = ZCell
    override def structure : List[Point] = List(Point(-1,1),Point(0,0),Point(0,1),Point(1,0))
}