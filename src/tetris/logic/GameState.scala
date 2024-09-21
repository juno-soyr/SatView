package tetris.logic

import tetris.logic.Tetronimo
import engine.random.RandomGenerator
import com.lowagie.text.Cell

class GameState(val randomGen : RandomGenerator,
                val board : Map[(Int,Int), CellType]){
    val allPieces : Map[Int, Tetronimo] = Map(
        0 -> IPiece(),  
        1 -> OPiece(),  
        2 -> TPiece(),  
        3 -> SPiece(),  
        4 -> ZPiece(),  
        5 -> JPiece(),  
        6 -> LPiece()
    )
    val piece : Tetronimo = allPieces(randomGen.randomInt(7))
    val piecePosition : List[Point] = piece.structure.map(p => Point(p.x, p.y - 3))
    def pointInPiece(p : Point) : Boolean = {
        for(i <- piecePosition){
            if(i.sameAs(p)){
                return true
            }
        }
        return false
    }

    val newBoard : Map[(Int,Int), CellType] = board.map {
        case (key, value) =>
            if(pointInPiece(Point(key._1, key._2))){
                key -> piece.cell
            }else{
                key -> Empty
            }
    }.toMap
}