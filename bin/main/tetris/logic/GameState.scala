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

    def boundCheck(currPos : List[Point]) : Int = {
        for(p <- currPos){
            if (p.x > gridDims.width - 1 || p.x < 0 ){
                return 2
            }
            else if(p.y > gridDims.height - 1){
                return 3
            }else if(board(p) != Empty){
                return 3
            }
        }
        return -1
    }
// use integers to check for specific bound behaviour


    def newPiecePlacement() : GameState = {
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
        val nBoard : Map[Point,CellType] = reloadBoard(newPieceAbsPos, piece.blockType)
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

        return new GameState(gridDims, randomGen,basePiece,newPiecePos,nBoard, false)
    }
    
    def rotatePieceLeft() : GameState = {
        val newPiece : Tetronimo = piece.rotateLeft
        val newPieceAbsPos : List[Point] = newPiece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            println("Rotated Left")
            return newGameState(newPiece = newPiece)
        }else{
            return newGameState()
        }
    }

    def rotatePieceRight() : GameState = {
        val newPiece : Tetronimo = piece.rotateRight
        val newPieceAbsPos : List[Point] = newPiece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            println("Rotated Right")
            return newGameState(newPiece = newPiece)
        }else{
            return newGameState()
        }
    }
    def moveLeft() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 - 1, piecePos._2)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            println("Moved Left")
            return newGameState(newPiecePos = newPiecePos)
        }else{
            return newGameState()
        }    
    }
    def moveRight() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 + 1, piecePos._2)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            println("Moved Right")
            return newGameState(newPiecePos = newPiecePos)
        }else{
            return newGameState()
        }
    }
    def moveDown() : GameState = {
        val nPiecePos : (Int, Int) = (piecePos._1, piecePos._2 + 1)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + nPiecePos._1, p.y + nPiecePos._2))
        if(boundCheck(newPieceAbsPos) == 3){
            println("newPiece")
            return newGameState( newNewPieceFlag = true)
        }else{
            return newGameState(newPiecePos = nPiecePos)
        }
    }

    def drop(currGameState : GameState) : GameState = {
        val nPiecePos : (Int, Int) = (piecePos._1, piecePos._2 + 1)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + nPiecePos._1, p.y + nPiecePos._2))
        if(currGameState.boundCheck(newPieceAbsPos) != 3){
            println("not at end, dropping more")
            val nGameState : GameState = currGameState.moveDown()
            return drop(nGameState)
        }
        return currGameState
    }

    def pointInPiece(piece : List[Point],p : Point) : Boolean = {
        for(i <- piece){
            if(i.sameAs(p)){
                return true
            }
        }
        return false
    }

    //use this only for setted pieces
    def checkLine(newBoard : Map[Point, CellType] ,y : Int) : Boolean = {
        newBoard.filter{ case(Point(_,col),_) => col == y
        }.forall{case (_, ctype) => ctype != Empty}
    }

    def clearOneLine(currBoard : Map[Point, CellType], col : Int) : Map[Point, CellType] = {
        if(checkLine(currBoard, col)){
            println("Removing line:", col)
            val newBoard : Map[Point, CellType]= currBoard.map{
                case(point @ Point(x,y), cellType) => 
                    if(point.y <= col){
                        val aboveCellType = currBoard.get(Point(x,y - 1)).getOrElse(cellType)
                        Point(x,y) -> aboveCellType
                    }else Point(x,y) -> cellType
            }
            return newBoard
        }else return currBoard 
    }
    def clearLines(currBoard : Map[Point, CellType],col : Int): Map[Point, CellType] = {
        if(col > gridDims.height - 1){
            currBoard
        }else{
            val nBoard : Map[Point, CellType] = clearOneLine(currBoard,col)
            clearLines(nBoard, col + 1)
        }
    }


    def reloadBoard(currPiecePos : List[Point], currPiece : CellType) : Map[Point, CellType] = {
        val newBoard : Map[Point, CellType] = board.map {
        case (key, value) =>
            if(pointInPiece(currPiecePos,key)){
                key -> currPiece
            }else{
                key -> value
            }
        }.toMap
        val nBoard : Map[Point, CellType] = clearLines(newBoard, 0)
        return nBoard
    }
    def newGameState(gridDims : Dimensions = gridDims, randomGen : RandomGenerator = randomGen, 
                    newPiece : Tetronimo = piece, newPiecePos : (Int, Int) = piecePos, 
                    newBoard : Map[Point, CellType] = board, newNewPieceFlag : Boolean = newPieceFlag)
                    : GameState = {
        if(!newNewPieceFlag){
            return new GameState(gridDims, randomGen, newPiece, newPiecePos, newBoard, newNewPieceFlag)
        }else{
            return new GameState(gridDims,randomGen, newPiece, newPiecePos, board, false).newPiecePlacement()
        }
    }
}