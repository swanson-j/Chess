package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public class Knight extends Piece{
    public Knight(boolean isWhite, boolean isCaptured){
        super(isWhite, isCaptured);
    }

    @Override
    public boolean canMove(Board board, Square startSquare, Square endSquare) {

        // the player cannot move to a square that also contains another of the same player's piece
        if(endSquare.getPiece() != null){
            if(endSquare.getPiece().isWhite() == this.isWhite())
                return false;
        }

        int xMove = Math.abs(startSquare.getX() - endSquare.getX());
        int yMove = Math.abs(startSquare.getY() - endSquare.getY());

        return xMove * yMove == 2;

    }
}
