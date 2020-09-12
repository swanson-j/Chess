package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public class Rook extends Piece{
    public Rook(boolean isWhite, boolean isCaptured){
        super(isWhite, isCaptured);
    }

    @Override
    public boolean canMove(Board board, Square startSquare, Square endSquare) {
        //TODO
        return false;
    }
}
