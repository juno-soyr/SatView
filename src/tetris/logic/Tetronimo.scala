package tetris.logic

import com.lowagie.text.Cell


class Tetronimo(val struct : List[Point], val blockType : CellType){
    def containsPoint(p : Point) : Boolean ={
        for(i <- struct){
            if(i.sameAs(p)) return true
        }
        return false
    }
}