package tetris.logic

import tetris.logic.Tetronimo
import engine.random.RandomGenerator
import com.lowagie.text.Cell
import java.text.Normalizer

class GameState(val gridDims : Dimensions, val randomGen : RandomGenerator,val piece : Tetronimo,val piecePos : (Int, Int) = (0,0), val board : Map[Point, CellType] ,val newPieceFlag : Boolean = false){
    val allPieces : Map[Int,(List[Point],CellType)] = Map(
        0 -> (List(Point(-1,0),Point(0,0),Point(1,0),Point(2,0)),ICell),
        1 -> (List(Point(-1,-1),Point(0,0),Point(-1,0),Point(1,0)),JCell),
        2 -> (List(Point(-1,0),Point(0,0),Point(1,0),Point(1,-1)),LCell),
        3 -> (List(Point(1,0),Point(0,0),Point(0,-1), Point(1,-1)),OCell),
        4 -> (List(Point(-1,0),Point(0,0),Point(0,-1),Point(1,-1)),SCell),
        5 -> (List(Point(-1,0),Point(0,0),Point(0,-1),Point(1,0)),TCell),
        6 -> (List(Point(-1,-1),Point(0,0),Point(0,-1),Point(1,0)),ZCell)
    )    
    val currPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
    def newPiecePlacement() : GameState = {
        val pieceIndex : Int = randomGen.randomInt(7)
        
        val basePiece : Tetronimo = 
            if(pieceIndex != 0 && pieceIndex != 3){
                new NormalTetronimo(pieceIndex, allPieces(pieceIndex)._1, allPieces(pieceIndex)._2)
            }else if(pieceIndex == 0){
                new ITetronimo
            }else{
                new OTetronimo
            }
        val newPiecePos : (Int, Int)= 
            if(gridDims.width % 2 != 0) {
                (gridDims.width / 2, 1)
            } else {
                ((gridDims.width / 2) - 1, 1)
            }

        val startingPosition : List[Point] = basePiece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        //val newBoard = reloadBoard(startingPosition, basePiece.blockType)
        return new GameState(gridDims, randomGen,basePiece,newPiecePos,board, false)
    }
    
    def rotatePieceLeft() : GameState = {
        val newPiece : Tetronimo = piece.rotateLeft
        println("Rotated Left")
        return new GameState(gridDims, randomGen, newPiece, piecePos, board, false)
    }

    def rotatePieceRight() : GameState = {
        val newPiece : Tetronimo = piece.rotateRight
        println("Rotated Right")
        return new GameState(gridDims, randomGen, newPiece, piecePos, board, false)
    }
    def moveLeft() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 - 1, piecePos._2)
        return new GameState(gridDims, randomGen, piece, newPiecePos, board, false)
    }
    def moveRight() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 + 1, piecePos._2)
        return new GameState(gridDims, randomGen, piece, newPiecePos, board, false)
    }
    def moveDown() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1, piecePos._2 + 1)
        return new GameState(gridDims, randomGen, piece, newPiecePos, board, false)
    }
    def pointInPiece(piece : List[Point],p : Point) : Boolean = {
        for(i <- piece){
            if(i.sameAs(p)){
                return true
            }
        }
        return false
    }

    //use this only for setted pieces?

    def reloadBoard(currPiecePos : List[Point], currPiece : CellType) : Map[Point, CellType] = {
        val newBoard : Map[Point, CellType] = board.map {
        case (key, value) =>
            if(pointInPiece(currPiecePos,key)){
                key -> currPiece
            }else{
                key -> value
            }
        }.toMap
        return newBoard
    }
}