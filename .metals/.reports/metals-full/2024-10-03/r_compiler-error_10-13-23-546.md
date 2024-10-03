file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/bin/main/tetris/logic/GameState.scala
### file%3A%2F%2F%2Fhome%2Fjuno%2FUni%2F2024-2025%2FPeriod%25201%2FOOFP%2FOOFP-Tetris-2024%2Fbin%2Fmain%2Ftetris%2Flogic%2FGameState.scala:71: error: `;` expected but `else` found
        }else{
         ^

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.14
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.14/scala-library-2.13.14.jar [exists ]
Options:



action parameters:
uri: file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/bin/main/tetris/logic/GameState.scala
text:
```scala
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
            else if(p.y > gridDims.height - 1){
                return 3
            }else if(boardVal(p) != Empty){
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
        
        val newNewPieceAbsPos : List[Point] = basePiece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newNewPieceAbsPos, nBoard) == 3){
            return this.copy(gameOver = true)
        }
        return this.copy(gridDims, randomGen,basePiece,newPiecePos,nBoard,newPieceFlag = false, drop = false)
    }
    
    def rotatePieceLeft() : GameState = {
        val newPiece : Tetronimo = piece.rotateLeft
        val newPieceAbsPos : List[Point] = newPiece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3)
            return this.copy(piece = newPiece)
        }else{
            return this.copy()
        }
    }

    def rotatePieceRight() : GameState = {
        val newPiece : Tetronimo = piece.rotateRight
        val newPieceAbsPos : List[Point] = newPiece.struct.map(p => Point(p.x + piecePos._1, p.y + piecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            println("Rotated Right")
            return this.copy(piece = newPiece)
        }else{
            return this.copy()
        }
    }
    def moveLeft() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 - 1, piecePos._2)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            println("Moved Left")
            return this.copy(piecePos = newPiecePos)
        }else{
            return this.copy()
        }    
    }
    def moveRight() : GameState = {
        val newPiecePos : (Int, Int) = (piecePos._1 + 1, piecePos._2)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + newPiecePos._1, p.y + newPiecePos._2))
        if(boundCheck(newPieceAbsPos) != 2 && boundCheck(newPieceAbsPos) != 3){
            println("Moved Right")
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

    def drop(currGameState : GameState) : GameState = {
        val nPiecePos : (Int, Int) = (piecePos._1, piecePos._2 + 1)
        val newPieceAbsPos : List[Point] = piece.struct.map(p => Point(p.x + nPiecePos._1, p.y + nPiecePos._2))
        if(!currGameState.newPieceFlag){
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

}
```



#### Error stacktrace:

```
scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:16)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.Reporter.syntaxError(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter.syntaxError$(Reporter.scala:17)
	scala.meta.internal.parsers.Reporter$$anon$1.syntaxError(Reporter.scala:22)
	scala.meta.internal.parsers.ScalametaParser.syntaxErrorExpected(ScalametaParser.scala:394)
	scala.meta.internal.parsers.ScalametaParser.acceptStatSep(ScalametaParser.scala:450)
	scala.meta.internal.parsers.ScalametaParser.acceptStatSepOpt(ScalametaParser.scala:452)
	scala.meta.internal.parsers.ScalametaParser.statSeqBuf(ScalametaParser.scala:4107)
	scala.meta.internal.parsers.ScalametaParser.getStats$2(ScalametaParser.scala:4137)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$scala$meta$internal$parsers$ScalametaParser$$templateStatSeq$3(ScalametaParser.scala:4138)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$scala$meta$internal$parsers$ScalametaParser$$templateStatSeq$3$adapted(ScalametaParser.scala:4136)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$listBy(ScalametaParser.scala:562)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$templateStatSeq(ScalametaParser.scala:4136)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$templateStatSeq(ScalametaParser.scala:4128)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$templateBody$1(ScalametaParser.scala:4006)
	scala.meta.internal.parsers.ScalametaParser.inBracesOr(ScalametaParser.scala:260)
	scala.meta.internal.parsers.ScalametaParser.inBraces(ScalametaParser.scala:256)
	scala.meta.internal.parsers.ScalametaParser.templateBody(ScalametaParser.scala:4006)
	scala.meta.internal.parsers.ScalametaParser.templateBodyOpt(ScalametaParser.scala:4009)
	scala.meta.internal.parsers.ScalametaParser.templateAfterExtends(ScalametaParser.scala:3960)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$templateOpt$1(ScalametaParser.scala:4001)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:325)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:369)
	scala.meta.internal.parsers.ScalametaParser.templateOpt(ScalametaParser.scala:3993)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$classDef$1(ScalametaParser.scala:3657)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:372)
	scala.meta.internal.parsers.ScalametaParser.autoEndPos(ScalametaParser.scala:377)
	scala.meta.internal.parsers.ScalametaParser.classDef(ScalametaParser.scala:3635)
	scala.meta.internal.parsers.ScalametaParser.tmplDef(ScalametaParser.scala:3600)
	scala.meta.internal.parsers.ScalametaParser.topLevelTmplDef(ScalametaParser.scala:3589)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$2.applyOrElse(ScalametaParser.scala:4121)
	scala.meta.internal.parsers.ScalametaParser$$anonfun$2.applyOrElse(ScalametaParser.scala:4115)
	scala.PartialFunction.$anonfun$runWith$1(PartialFunction.scala:231)
	scala.PartialFunction.$anonfun$runWith$1$adapted(PartialFunction.scala:230)
	scala.meta.internal.parsers.ScalametaParser.statSeqBuf(ScalametaParser.scala:4107)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$statSeq$1(ScalametaParser.scala:4096)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$statSeq$1$adapted(ScalametaParser.scala:4096)
	scala.meta.internal.parsers.ScalametaParser.scala$meta$internal$parsers$ScalametaParser$$listBy(ScalametaParser.scala:562)
	scala.meta.internal.parsers.ScalametaParser.statSeq(ScalametaParser.scala:4096)
	scala.meta.internal.parsers.ScalametaParser.bracelessPackageStats$1(ScalametaParser.scala:4285)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$source$1(ScalametaParser.scala:4288)
	scala.meta.internal.parsers.ScalametaParser.atPos(ScalametaParser.scala:325)
	scala.meta.internal.parsers.ScalametaParser.autoPos(ScalametaParser.scala:369)
	scala.meta.internal.parsers.ScalametaParser.source(ScalametaParser.scala:4264)
	scala.meta.internal.parsers.ScalametaParser.entrypointSource(ScalametaParser.scala:4291)
	scala.meta.internal.parsers.ScalametaParser.parseSourceImpl(ScalametaParser.scala:119)
	scala.meta.internal.parsers.ScalametaParser.$anonfun$parseSource$1(ScalametaParser.scala:116)
	scala.meta.internal.parsers.ScalametaParser.parseRuleAfterBOF(ScalametaParser.scala:58)
	scala.meta.internal.parsers.ScalametaParser.parseRule(ScalametaParser.scala:53)
	scala.meta.internal.parsers.ScalametaParser.parseSource(ScalametaParser.scala:116)
	scala.meta.parsers.Parse$.$anonfun$parseSource$1(Parse.scala:30)
	scala.meta.parsers.Parse$$anon$1.apply(Parse.scala:37)
	scala.meta.parsers.Api$XtensionParseDialectInput.parse(Api.scala:22)
	scala.meta.internal.semanticdb.scalac.ParseOps$XtensionCompilationUnitSource.toSource(ParseOps.scala:15)
	scala.meta.internal.semanticdb.scalac.TextDocumentOps$XtensionCompilationUnitDocument.toTextDocument(TextDocumentOps.scala:161)
	scala.meta.internal.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:54)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$semanticdbTextDocument$1(ScalaPresentationCompiler.scala:469)
```
#### Short summary: 

file%3A%2F%2F%2Fhome%2Fjuno%2FUni%2F2024-2025%2FPeriod%25201%2FOOFP%2FOOFP-Tetris-2024%2Fbin%2Fmain%2Ftetris%2Flogic%2FGameState.scala:71: error: `;` expected but `else` found
        }else{
         ^