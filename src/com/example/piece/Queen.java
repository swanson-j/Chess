package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public class Queen extends Piece{
    public Queen(boolean isWhite, boolean isCaptured){
        super(isWhite, isCaptured);
    }

    @Override
    public boolean canMove(Board board, Square startSquare, Square endSquare) {
        if(endSquare.getPiece() != null){
            if(this.isWhite() == endSquare.getPiece().isWhite()) {
                return false;
            }
        }

        Rook rook = new Rook(this.isWhite(), false);
        Bishop bishop = new Bishop(this.isWhite(), false);

        if(rook.canMove(board, startSquare, endSquare) || bishop.canMove(board, startSquare, endSquare)){
            return true;
        }
        return false;
    }
}
