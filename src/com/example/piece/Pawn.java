package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public class Pawn extends Piece {
    private boolean hasMoved = false;

    public Pawn(boolean isWhite, boolean isCaptured){
        super(isWhite, isCaptured);
    }

    public boolean hasMoved(){
        return this.hasMoved;
    }

    public void setHasMoved(boolean hasMoved){
        this.hasMoved = hasMoved;
    }

    @Override
    public boolean canMove(Board board, Square startSquare, Square endSquare){
        //TODO
        return true;
    }
}
