package com.example.move;

import com.example.piece.Piece;
import com.example.square.Square;

public class Move {
    private Piece pieceMoved;
    private Piece pieceCaptured;
    private Square startSquare;
    private Square endSquare;

    public Move(Piece pieceMoved, Piece pieceCaptured, Square startSquare, Square endSquare){
        this.pieceMoved = pieceMoved;
        this.pieceCaptured = pieceCaptured;
        this.startSquare = startSquare;
        this.endSquare = endSquare;
    }
}
