package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public class Bishop extends Piece {
    public Bishop(boolean isWhite, boolean isCaptured){
        super(isWhite, isCaptured);
    }

    @Override
    public boolean canMove(Board board, Square startSquare, Square endSquare) {

        // bishop cannot capture same color piece
        if(endSquare.getPiece() != null){
            if(endSquare.getPiece().isWhite() == this.isWhite())
                return false;
        }

        int xMove = endSquare.getX() - startSquare.getX();
        int yMove = endSquare.getY() - startSquare.getY();

        // bishop is not moving diagonally
        if(Math.abs(xMove) != Math.abs(yMove)){
            return false;
        }
        return false;
    }
}
