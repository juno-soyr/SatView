error id: file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/src/tetris/logic/Tetronimo.scala:[983..984) in Input.VirtualFile("file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/src/tetris/logic/Tetronimo.scala", "package tetris.logic

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
}
class ITetronimo extends Tetronimo { 
    val struct = allPieces(0)._1
    val blockType = allPieces(0)._2
}
class 0Tetronimo extends  Tetronimo {

}")
file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/src/tetris/logic/Tetronimo.scala
file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/src/tetris/logic/Tetronimo.scala:30: error: expected identifier; obtained intlit
class 0Tetronimo extends  Tetronimo {
      ^
#### Short summary: 

expected identifier; obtained intlit