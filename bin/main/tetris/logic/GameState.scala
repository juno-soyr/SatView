package tetris.logic

import tetris.logic.Tetronimo
import engine.random.RandomGenerator
import com.lowagie.text.Cell

case class GameState(val gridDims : Dimensions, val randomGen : RandomGenerator,
                val piece : Tetronimo,val piecePos : (Int, Int) = (0,0), val board : Map[Point, CellType] ,
                val newPieceFlag : Boolean = false, val gameOver : Boolean = false, val drop : Boolean = false){


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

    def boundCheck(currPos : List[Point], boardVal : Map[Point, CellType] = board) : Int = {
        for(p <- currPos){
            if (p.x > gridDims.width - 1 || p.x < 0 ){
                return 2
            }
            else if(p.y > gridDims.height - 1 || boardVal(p) != Empty){
                return 3
            }
        }
        return -1
    }
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
        
        val newNewPieceAbsPos : List[Point] = basePiece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newNewPieceAbsPos, nBoard) == 3){
            return this.copy(gameOver = true)
        }
        return this.copy(gridDims, randomGen,basePiece,newPiecePos,nBoard,newPieceFlag = false, drop = false)
    }
    
    def rotatePieceLeft() : GameState = {
        val newPiece : Tetronimo = piece.rotateLeft
        val newPieceAbsPos : List[Point] = newPiece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            return this.copy(piece = newPiece)
        }else{
            return this.copy()
        }
    }

    def rotatePieceRight() : GameState = {
        val newPiece : Tetronimo = piece.rotateRight
        val newPieceAbsPos : List[Point] = newPiece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            return this.copy(piece = newPiece)
        }else{
            return this.copy()
        }
    }
    def moveLeft() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 - 1, piecePos._2)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            return this.copy(piecePos = newPiecePos)
        }else{
            return this.copy()
        }    
    }
    def moveRight() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 + 1, piecePos._2)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            return this.copy(piecePos = newPiecePos)
        }else{
            return this.copy()
        }
    }
    def moveDown() : GameState = {
        val nPiecePos : (Int, Int) = (piecePos._1, piecePos._2 + 1)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + nPiecePos._1, p.y + nPiecePos._2))
        if(boundCheck(newPieceAbsPos) == 3 && !drop){
            return this.copy(newPieceFlag = true).newPiecePlacement()
        }else if(boundCheck(newPieceAbsPos) == 3 && drop){
            return this.copy(newPieceFlag = true)
        }
        else{
            return this.copy(piecePos = nPiecePos)
        }
    }

    def checkLine(newBoard : Map[Point, CellType] ,y : Int) : Boolean = {
        newBoard.filter{ case(Point(_,col),_) => col == y
        }.forall{case (_, cell) => cell != Empty}
    }

    def clearOneLine(currBoard : Map[Point, CellType], col : Int) : Map[Point, CellType] = {
        if(checkLine(currBoard, col)){
            val newBoard : Map[Point, CellType]= currBoard.map{
                case(point @ Point(x,y), cell) => 
                    if(point.y <= col){
                        val aboveCell = currBoard.get(Point(x,y - 1)).getOrElse(cell)
                        Point(x,y) -> aboveCell
                    }else Point(x,y) -> cell
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
            if(currPiecePos.contains(key)){
                key -> currPiece
            }else{
                key -> value
            }
        }.toMap
        val nBoard : Map[Point, CellType] = clearLines(newBoard, 0)
        return nBoard
    }

}