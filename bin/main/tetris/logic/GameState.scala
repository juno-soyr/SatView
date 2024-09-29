package tetris.logic

import tetris.logic.Tetronimo
import engine.random.RandomGenerator
import com.lowagie.text.Cell

class GameState(val randomGen : RandomGenerator, val board : Map[Point, CellType], val currentPosition : List[Point] = List(), val pieceType : CellType = Empty,val newPiece : Boolean = false){


    val allPieces : Map[Int,(List[Point],CellType)] = Map(
        0 -> (List(Point(-1,0),Point(0,0),Point(1,0),Point(2,0)),ICell),
        1 -> (List(Point(-1,1),Point(0,0),Point(-1,0),Point(1,0)),JCell),
        2 -> (List(Point(-1,0),Point(0,0),Point(1,0),Point(1,1)),LCell),
        3 -> (List(Point(-1,1),Point(-1,0),Point(0,0),Point(0,1)),OCell),
        4 -> (List(Point(-1,0),Point(0,0),Point(0,1),Point(1,1)),SCell),
        5 -> (List(Point(-1,0),Point(0,0),Point(0,1),Point(1,0)),TCell),
        6 -> (List(Point(-1,1),Point(0,0),Point(0,1),Point(1,0)),ZCell)

    )    

    //setup diferently                    

    def newPiecePlacement() : GameState = {
        val pieceIndex : Int = randomGen.randomInt(7)
        val piece : Tetronimo = new Tetronimo(allPieces(pieceIndex)._1, allPieces(pieceIndex)._2)
        val startingPosition : List[Point] = piece.struct.map(p => Point(p.x + 3, p.y + 4))
        println("Piece type: ", piece.blockType)
        val newBoard : Map[Point, CellType] = board.map {
        case (key, value) =>
            if(pointInPiece(startingPosition,key)){
                println(key)
                key -> pieceType
            }else{
                key -> value
            }
        }.toMap
        return new GameState(randomGen, newBoard, startingPosition, piece.blockType, false)
    }
    
    def pointInPiece(piece : List[Point],p : Point) : Boolean = {
        for(i <- piece){
            if(i.sameAs(p)){
                return true
            }
        }
        return false
    }



    def newGameState(board : Map[Point,CellType], currentPosition : List[Point] = currentPosition ,pieceType : CellType = pieceType, newPiece : Boolean = newPiece) : GameState = {
        return new GameState(randomGen, board, currentPosition,pieceType ,newPiece)
    }
}