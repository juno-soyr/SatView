package tetris.logic

import tetris.logic.Tetronimo
import engine.random.RandomGenerator
import com.lowagie.text.Cell

class GameState(val randomGen : RandomGenerator,
                val board : Map[(Int,Int), CellType]){
    val allPieces : Map[Int,(List[Point],CellType)] = Map(
        0 -> (List(Point(-1,0),Point(0,0),Point(1,0),Point(2,0)),ICell),
        1 -> (List(Point(-1,1),Point(-1,0),Point(1,0)),JCell),
        2 -> (List(Point(-1,0),Point(1,0),Point(1,1)),LCell),
        3 -> (List(Point(-1,1),Point(-1,0),Point(0,0),Point(0,1)),OCell),
        4 -> (List(Point(-1,0),Point(0,1),Point(1,1)),SCell),
        5 -> (List(Point(-1,0),Point(0,1),Point(1,0)),TCell),
        6 -> (List(Point(-1,1),Point(0,1),Point(1,0)),ZCell)

    )                        
    val pieceIndex : Int = randomGen.randomInt(7)
    val piece : Tetronimo = new Tetronimo(allPieces(pieceIndex)._1, allPieces(pieceIndex)._2)
   // val piecePosition : List[Point] = piece.structure.map(p => Point(p.x, p.y + 3))
    //println(piecePosition)
    def pointInPiece(p : Point) : Boolean = {
        for(i <- piece.struct){
            if(i.sameAs(p)){
                return true
            }
        }
        return false
    }

    val newBoard : Map[(Int,Int), CellType] = board.map {
        case (key, value) =>
            if(pointInPiece(Point(key._1, key._2))){
                //println(piece.cell)
                key -> piece.blockType
            }else{
                key -> Empty
            }
    }.toMap
}