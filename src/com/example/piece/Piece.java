package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public abstract class Piece {
    private boolean isWhite;
    private boolean isCaptured;

    public Piece(boolean isWhite, boolean isCaptured){
        setIsWhite(isWhite);
        setIsCapture(isCaptured);
    }

    public boolean isWhite(){
        return this.isWhite;
    }

    public void setIsWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

    public boolean isCaptured(){
        return this.isCaptured;
    }

    public void setIsCapture(boolean isCaptured){
        this.isCaptured = isCaptured;
    }

    // Check if piece is making a legal move
    public abstract boolean canMove(Board board, Square startSquare, Square endSquare);
}

