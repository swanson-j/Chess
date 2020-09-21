package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public class King extends Piece{

    private boolean hasCastled = false;

    public King(boolean isWhite, boolean isCaptured){
        super(isWhite, isCaptured);
    }

    public boolean hasCastled(){
        return this.hasCastled;
    }

    public void setHasCastled(boolean hasCastled){
        this.hasCastled = hasCastled;
    }

    @Override
    public boolean canMove(Board board, Square startSquare, Square endSquare) {
        // rook cannot capture same colored piece
        if(endSquare.getPiece() != null){
            if(endSquare.getPiece().isWhite() == this.isWhite())
                return false;
        }

        //TODO: Finish castling functionality

        int xMove = endSquare.getX() - startSquare.getX();
        int yMove = endSquare.getY() - startSquare.getY();

        // King is not moving correctly
        if((xMove == 0 && yMove == 0) || Math.abs(xMove) > 1 || Math.abs(yMove) > 1){
            return false;
        }

        return true;
    }
}
