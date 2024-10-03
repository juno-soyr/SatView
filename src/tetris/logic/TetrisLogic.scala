package tetris.logic

import engine.random.{RandomGenerator, ScalaRandomGen}
import tetris.logic.TetrisLogic._
import com.lowagie.text.Cell


/** To implement Tetris, complete the ``TODOs`` below.
 *
 * If you need additional files,
 * please also put them in the ``tetris`` package.
 */
class TetrisLogic(val randomGen: RandomGenerator,
                  val gridDims : Dimensions,
                  val initialBoard: Seq[Seq[CellType]]) {

  def this(random: RandomGenerator, gridDims : Dimensions) =
    this(random, gridDims, makeEmptyBoard(gridDims))

  def this() =
    this(new ScalaRandomGen(), DefaultDims, makeEmptyBoard(DefaultDims))

  val initialBoardMap: Map[Point, CellType] =  (
    for {
      x <- 0 until gridDims.width 
      y <- 0 until gridDims.height
    } yield if(initialBoard(y)(x) != Empty) Point(x,y) -> initialBoard(y)(x)
      else Point(x,y) -> Empty
  ).toMap

  var currGameState : GameState = new GameState(gridDims, randomGen, new NormalTetronimo(0, List(), Empty),(0,0),initialBoardMap).newPiecePlacement()

  def rotateLeft(): Unit = {
    currGameState = currGameState.rotatePieceLeft()
  }
  def rotateRight(): Unit = {
    currGameState = currGameState.rotatePieceRight()
  }
  def moveLeft(): Unit = {
    currGameState = currGameState.moveLeft()
  }
  def moveRight(): Unit = {
    currGameState = currGameState.moveRight()
  }

  def moveDown(): Unit = {
    currGameState = currGameState.moveDown()
  }

  def doHardDrop(): Unit = {
    val nPiecePos : (Int, Int) = (currGameState.piecePos._1, currGameState.piecePos._2 + 1)
    val newPieceAbsPos : List[Point] = currGameState.piece.struct.map(p => Point(p.x + nPiecePos._1, p.y + nPiecePos._2))
    currGameState = currGameState.copy(drop = true)
    while(!currGameState.newPieceFlag){
      currGameState = currGameState.moveDown() 
    }
    currGameState = currGameState.newPiecePlacement()
  }

  def isGameOver: Boolean = {
    currGameState.gameOver
  }

  def getCellType(p : Point): CellType = {
    if(currGameState.currPieceAbsPos.contains(p)){
      currGameState.piece.blockType
    }else{
      currGameState.board(p)
    }
  }
}

object TetrisLogic {

  val FramesPerSecond: Int = 5 // change this to speed up or slow down the game

  val DrawSizeFactor = 1.0 // increase this to make the game bigger (for high-res screens)
  // or decrease to make game smaller



  def makeEmptyBoard(gridDims : Dimensions): Seq[Seq[CellType]] = {
    val emptyLine = Seq.fill(gridDims.width)(Empty)
    Seq.fill(gridDims.height)(emptyLine)
  }


  // These are the dimensions used when playing the game.
  // When testing the game, other dimensions are passed to
  // the constructor of GameLogic.
  //
  // DO NOT USE the variable DefaultGridDims in your code!
  //
  // Doing so will cause tests which have different dimensions to FAIL!
  //
  // In your code only use gridDims.width and gridDims.height
  // do NOT use DefaultDims.width and DefaultDims.height


  val DefaultWidth: Int = 10
  val NrTopInvisibleLines: Int = 4
  val DefaultVisibleHeight: Int = 20
  val DefaultHeight: Int = DefaultVisibleHeight + NrTopInvisibleLines
  val DefaultDims : Dimensions = Dimensions(width = DefaultWidth, height = DefaultHeight)


  def apply() = new TetrisLogic(new ScalaRandomGen(),
    DefaultDims,
    makeEmptyBoard(DefaultDims))

}