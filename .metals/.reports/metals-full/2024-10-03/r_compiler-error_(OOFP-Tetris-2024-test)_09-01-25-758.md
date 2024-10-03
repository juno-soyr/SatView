file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/test/tetris/TetrisTestSuiteBase.scala
### java.lang.NullPointerException: Cannot invoke "scala.reflect.internal.Symbols$Symbol.isImplicit()" because the return value of "scala.reflect.internal.Trees$Tree.symbol()" is null

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 2.13.14
Classpath:
<WORKSPACE>/.bloop/OOFP-Tetris-2024-test/build/bloop-bsp-clients-classes/classes-Metals-drhLUOShT4eiUwKy9SXpIw== [exists ], <HOME>/.cache/bloop/semanticdb/com.sourcegraph.semanticdb-javac.0.10.0/semanticdb-javac-0.10.0.jar [exists ], <WORKSPACE>/.bloop/OOFP-Tetris-2024/build/bloop-bsp-clients-classes/classes-Metals-drhLUOShT4eiUwKy9SXpIw== [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/com.github.micycle1/processing-core-4/4.3/8a76254386cc6fa2aab4ea8a639e78caca0310c0/processing-core-4-4.3.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt-main/2.5.0-rc-20230523/6a86a9ce357c085e3052efcf639447f9957b82b8/gluegen-rt-main-2.5.0-rc-20230523.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt/2.5.0-rc-20230523/96d48dbc86c688a470e7aa97a1b326efb154c288/gluegen-rt-2.5.0-rc-20230523.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt/2.5.0-rc-20230523/8617b0ba19376ec26f0e37ac9411f4473711784f/gluegen-rt-2.5.0-rc-20230523-natives-android-aarch64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt/2.5.0-rc-20230523/1a09dbfc2f68d81fbd6721cbd45f2621cabe127b/gluegen-rt-2.5.0-rc-20230523-natives-linux-amd64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt/2.5.0-rc-20230523/61976e00bb1108775a2d7c3645c3ccea4e2eb652/gluegen-rt-2.5.0-rc-20230523-natives-linux-armv6hf.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt/2.5.0-rc-20230523/6514d21a2a75f9a67a95309d2a825224c76fab1/gluegen-rt-2.5.0-rc-20230523-natives-linux-aarch64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt/2.5.0-rc-20230523/e92a2d36d36522d8827ce18ad16fb6d75c632576/gluegen-rt-2.5.0-rc-20230523-natives-macosx-universal.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.gluegen/gluegen-rt/2.5.0-rc-20230523/11c0e74f480b526ebc012cf20ea58feb96bb68c7/gluegen-rt-2.5.0-rc-20230523-natives-windows-amd64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.scalatest/scalatest_2.13/3.0.9/7f61bc9494ad925e6f40724f8997e2c45105cacb/scalatest_2.13-3.0.9.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.scalactic/scalactic_2.13/3.0.9/4a329d00a82630f56332d9c31a6a9ecd078655ae/scalactic_2.13-3.0.9.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala-reflect/2.13.3/eb08a460df09947c423e5ce77b3d4af566085f1/scala-reflect-2.13.3.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.scala-lang.modules/scala-xml_2.13/1.2.0/f6abd60d28c189f05183b26c5363713d1d126b83/scala-xml_2.13-1.2.0.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala-library/2.13.14/f8b4afe89abe48ca670f620c7da89b71f93e6546/scala-library-2.13.14.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.junit.platform/junit-platform-engine/1.9.0/bd46891f01817b5ffdd368cb0482a34746610acb/junit-platform-engine-1.9.0.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.junit.platform/junit-platform-commons/1.9.0/b727889107fc28c7460b21d1083212f8ce7602c6/junit-platform-commons-1.9.0.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.junit.vintage/junit-vintage-engine/5.9.0/b4980fe3c30b330ffa118fc1e732c804260d0bf6/junit-vintage-engine-5.9.0.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/junit/junit/4.13.2/8ac9e16d933b6fb43bc7f576336b8f4d7eb5ba12/junit-4.13.2.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.openjfx/javafx-controls/19.0.2.1/5cd256c5fc0974ed662b48ee8da232f8b736fe8a/javafx-controls-19.0.2.1.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all-main/2.5.0-rc-20230523/6a86a9ce357c085e3052efcf639447f9957b82b8/jogl-all-main-2.5.0-rc-20230523.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-svggen/1.16/714b527914c8295bc1f479b60b0d257357c1318c/batik-svggen-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-dom/1.16/2d0d63c9177d5c25b52061464457478e9f74363a/batik-dom-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/com.lowagie/itext/2.1.7/892bfb3e97074a61123b3b2d7caa2db112750864/itext-2.1.7.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/antlr/antlr/2.7.7/83cd2cd674a217ade95a4bb83a8a14f351f48bd0/antlr-2.7.7.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.hamcrest/hamcrest-core/1.3/42a25dc3219429f0e5d060061f71acb49bf010a0/hamcrest-core-1.3.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apiguardian/apiguardian-api/1.1.2/a231e0d844d2721b0fa1b238006d15c6ded6842a/apiguardian-api-1.1.2.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.openjfx/javafx-graphics/19.0.2.1/c1f87742c6d96f3e68334fa53d58b343f254f59f/javafx-graphics-19.0.2.1.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all/2.5.0-rc-20230523/2429bbff629e6324e8383d7ce2c6a585d7a0d518/jogl-all-2.5.0-rc-20230523.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all/2.5.0-rc-20230523/75fdccf9aa08ebba549f6a1e3b0a5a5155d68ace/jogl-all-2.5.0-rc-20230523-natives-android-aarch64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all/2.5.0-rc-20230523/952f5de3e278ee131ba84f0dfcd43036940b5ad1/jogl-all-2.5.0-rc-20230523-natives-linux-amd64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all/2.5.0-rc-20230523/26aaf64f37dec9e86e387d29461c7c2eff322419/jogl-all-2.5.0-rc-20230523-natives-linux-armv6hf.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all/2.5.0-rc-20230523/bb9eb649b305ccf21ba461206680bba51d8bc6e3/jogl-all-2.5.0-rc-20230523-natives-linux-aarch64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all/2.5.0-rc-20230523/916d54e1c49b557ddd39030093f64498fd65c0e6/jogl-all-2.5.0-rc-20230523-natives-macosx-universal.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.jogamp.jogl/jogl-all/2.5.0-rc-20230523/dba028035b76e1a8f70fb4fa803d9d8c3286109f/jogl-all-2.5.0-rc-20230523-natives-windows-amd64.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-awt-util/1.16/2f884535c65e892cfe14c7cdc660274528ec15f0/batik-awt-util-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-css/1.16/9151bffd3799b8f55fb27b81f06156183ffeb307/batik-css-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-xml/1.16/3055a9f0b0ee5b327c35c62749189b1c4683bc56/batik-xml-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-util/1.16/cc144a6a69fac333e5ed10ac3169768ceff2b840/batik-util-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-ext/1.16/3114e178d00db9053498f23cc46668b93c44dbc5/batik-ext-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-constants/1.16/924370bb08a8ef1d3983d5ea587a17c7845d9af6/batik-constants-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-i18n/1.16/6e45a40b5e67f89d528bb511d7d938c161dcbc1f/batik-i18n-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/batik-shared-resources/1.16/75809160dd805a8ce29b655671cd29e47da43efd/batik-shared-resources-1.16.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/xml-apis/xml-apis-ext/1.3.04/41a8b86b358e87f3f13cf46069721719105aff66/xml-apis-ext-1.3.04.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/bouncycastle/bcmail-jdk14/138/14ff2dfec8578f5f6838c4d6a77a86789afe5382/bcmail-jdk14-138.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/bouncycastle/bcprov-jdk14/138/de366c3243a586eb3c0e2bcde1ed9bb1bfb985ff/bcprov-jdk14-138.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.opentest4j/opentest4j/1.2.0/28c11eb91f9b6d8e200631d46e20a7f407f2a046/opentest4j-1.2.0.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.openjfx/javafx-base/19.0.2.1/2667dcd38eb1c7d13998b9ce7ff7dd4f9b63c540/javafx-base-19.0.2.1.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.apache.xmlgraphics/xmlgraphics-commons/2.7/336ddd6d0a244cdebf26a298fb7c3a5fd45449db/xmlgraphics-commons-2.7.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.bouncycastle/bctsp-jdk14/1.38/4821122f8390d15f4b5ee652621e2a2bb1f1bf16/bctsp-jdk14-1.38.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/commons-io/commons-io/1.3.1/b90b6ac57cf27a2858eaa490d02ba7945d18ca7b/commons-io-1.3.1.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/commons-logging/commons-logging/1.0.4/f029a2aefe2b3e1517573c580f948caac31b1056/commons-logging-1.0.4.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.bouncycastle/bcmail-jdk14/1.38/14ff2dfec8578f5f6838c4d6a77a86789afe5382/bcmail-jdk14-1.38.jar [exists ], <HOME>/.gradle/caches/modules-2/files-2.1/org.bouncycastle/bcprov-jdk14/1.38/de366c3243a586eb3c0e2bcde1ed9bb1bfb985ff/bcprov-jdk14-1.38.jar [exists ]
Options:
-deprecation -unchecked -Yrangepos -Xplugin-require:semanticdb


action parameters:
uri: file://<HOME>/Uni/2024-2025/Period%201/OOFP/OOFP-Tetris-2024/test/tetris/TetrisTestSuiteBase.scala
text:
```scala
// DO NOT MODIFY FOR BASIC SUBMISSION
// scalastyle:off

package tetris

import engine.random.RandomGenerator
import generic.{CellTypeInterface, GameLogicInterface, GameTestSuite}
import tetris.logic.{CellType, Dimensions, Empty, ICell, JCell, LCell, OCell, Point, SCell, TCell, TetrisLogic, ZCell}

sealed abstract class TetrisAction
case object RotateLeft    extends TetrisAction
case object RotateRight   extends TetrisAction
case object Down          extends TetrisAction
case object Left          extends TetrisAction
case object Right         extends TetrisAction
case object Drop          extends TetrisAction

case class TetrisGridTypeWrapper(gridType : CellType)  extends CellTypeInterface[TetrisGridTypeWrapper]{
  override def conforms(rhs : TetrisGridTypeWrapper) : Boolean = gridType == rhs.gridType

  override def toChar: Char = gridType match {
    case ICell  => 'I'
    case JCell  => 'J'
    case LCell  => 'L'
    case OCell  => 'O'
    case SCell  => 'S'
    case TCell  => 'T'
    case ZCell  => 'Z'
    case Empty   => '.'
  }
}


case class TetrisLogicWrapper
(randomGentlw : RandomGenerator,
 gridDimstlw : Dimensions,
 initialBoardtlw : Seq[Seq[CellType]])
  extends TetrisLogic(randomGentlw,gridDimstlw,initialBoardtlw) with GameLogicInterface[TetrisAction, TetrisGridTypeWrapper]{
  override def performAction(action: TetrisAction): Unit = action match {
    case RotateLeft => rotateLeft()
    case RotateRight => rotateRight()
    case Down => moveDown()
    case Left => moveLeft()
    case Right => moveRight()
    case Drop => doHardDrop()
  }

  override def getCell(col: Int , row: Int): TetrisGridTypeWrapper = TetrisGridTypeWrapper(getCellType(Point(col,row)))

  override def nrRows: Int = gridDimstlw.height
  override def nrColumns: Int = gridDimstlw.width
}


class TetrisTestSuiteBase  extends GameTestSuite
  [TetrisAction, TetrisGridTypeWrapper, TetrisLogicWrapper, (Dimensions, Seq[Seq[CellType]])]() {
  def charToGridType(char: Char) : TetrisGridTypeWrapper = TetrisGridTypeWrapper(char match {
    case 'I' => ICell
    case 'J' => JCell
    case 'L' => LCell
    case 'O' => OCell
    case 'S' => SCell
    case 'T' => TCell
    case 'Z' => ZCell
    case '.' => Empty
  })


  def emptyBoard( dims : Dimensions) : Seq[Seq[CellType]] = {
    val emptyLine = Seq.fill(dims.width)(Empty)
    Seq.fill(dims.height)(emptyLine)
  }

  override def makeGame(random: RandomGenerator, initialInfo: (Dimensions, Seq[Seq[CellType]])): TetrisLogicWrapper =
    new TetrisLogicWrapper(random,initialInfo._1, initialInfo._2)

  override def gameLogicName: String = "TetrisLogic"


  private def toTestRecording(initialBoardString : Option[String], frames : Seq[TestFrame]) : TestRecording = {
    val dimensions: Dimensions = frames.head.display match {
      case grid: GridDisplay => Dimensions(width = grid.nrColumns, height = grid.nrRows)
      case _ => throw new Error("No grid display in test")
    }
    def parseInitialField(s : String) : Seq[Seq[CellType]] =
      stringToGridDisplay(s).grid.map(_.map(_.gridType))
    val board = initialBoardString match {
      case Some(s) => parseInitialField(s)
      case _ => emptyBoard(dimensions)
    }
    TestRecording((dimensions, board),frames)
  }

  private def toTestRecording(initialBoard : String, frames : Seq[TestFrame]) : TestRecording = {
    toTestRecording(Some(initialBoard),frames)
  }

  private def toTestRecording(frames : Seq[TestFrame]) : TestRecording = {
    toTestRecording(None,frames)
  }

  def checkGame(frames : Seq[TestFrame], hint : String = ""  ) : Unit =
    checkGame(toTestRecording(frames), hint )

  def checkGame(initialBoard : String, frames : Seq[TestFrame], hint : String  ) : Unit =
    checkGame(toTestRecording(initialBoard,frames), hint )

  def checkInterleave(framesA : Seq[TestFrame] , framesB : Seq[TestFrame]) : Unit = {
    checkInterleave(toTestRecording(framesA), toTestRecording(framesB))
  }


}

```



#### Error stacktrace:

```
scala.meta.internal.pc.PcCollector.isCorrectPos(PcCollector.scala:93)
	scala.meta.internal.pc.PcCollector.isCorrectPos$(PcCollector.scala:92)
	scala.meta.internal.pc.BySymbolPCReferencesProvider.isCorrectPos(PcReferencesProvider.scala:59)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:126)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$7(PcCollector.scala:167)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:167)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$24(PcCollector.scala:311)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:311)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:168)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$24(PcCollector.scala:311)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:311)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$15(PcCollector.scala:251)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:251)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$24(PcCollector.scala:311)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:311)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$15(PcCollector.scala:251)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:251)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$24(PcCollector.scala:311)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:311)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$15(PcCollector.scala:251)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:251)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$1(PcCollector.scala:104)
	scala.meta.internal.pc.PcCollector.$anonfun$traverseSought$15(PcCollector.scala:251)
	scala.collection.LinearSeqOps.foldLeft(LinearSeq.scala:183)
	scala.collection.LinearSeqOps.foldLeft$(LinearSeq.scala:179)
	scala.collection.immutable.List.foldLeft(List.scala:79)
	scala.meta.internal.pc.PcCollector.traverseWithParent$1(PcCollector.scala:251)
	scala.meta.internal.pc.PcCollector.traverseSought(PcCollector.scala:314)
	scala.meta.internal.pc.PcCollector.traverseSought$(PcCollector.scala:95)
	scala.meta.internal.pc.BySymbolPCReferencesProvider.traverseSought(PcReferencesProvider.scala:59)
	scala.meta.internal.pc.PcCollector.resultWithSought(PcCollector.scala:82)
	scala.meta.internal.pc.PcCollector.resultWithSought$(PcCollector.scala:17)
	scala.meta.internal.pc.BySymbolPCReferencesProvider.resultWithSought(PcReferencesProvider.scala:59)
	scala.meta.internal.pc.BySymbolPCReferencesProvider.result(PcReferencesProvider.scala:72)
	scala.meta.internal.pc.PcReferencesProvider.references(PcReferencesProvider.scala:39)
	scala.meta.internal.pc.PcReferencesProvider.references$(PcReferencesProvider.scala:38)
	scala.meta.internal.pc.BySymbolPCReferencesProvider.references(PcReferencesProvider.scala:59)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$references$1(ScalaPresentationCompiler.scala:445)
```
#### Short summary: 

java.lang.NullPointerException: Cannot invoke "scala.reflect.internal.Symbols$Symbol.isImplicit()" because the return value of "scala.reflect.internal.Trees$Tree.symbol()" is null