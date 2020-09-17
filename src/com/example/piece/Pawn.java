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

        // player cannot move to a square that also contains another of the same player's piece
        if(endSquare.getPiece().isWhite() == this.isWhite()){
            return false;
        }

        // pawn cannot move backwards
        if(this.isWhite()){
            if(endSquare.getX() > startSquare.getX()){
                return false;
            }
        }else{
            if(endSquare.getX() < startSquare.getX()){
                return false;
            }
        }

        // player is moving pawn up or down the board without capturing
        if(startSquare.getX() != endSquare.getX() && startSquare.getY() == endSquare.getY()){

            // pawn can't move forward into another piece
            if(endSquare.getPiece() != null){
                return false;
            }

            int xMove = Math.abs(startSquare.getX() - endSquare.getX());

            if(xMove == 1){
                return true;
            } else if(xMove == 2){
                if(this.hasMoved == false){
                    if(this.isWhite()){
                        if(board.board[startSquare.getX()-1][startSquare.getY()].getPiece() == null && !this.hasMoved()){
                            return true;
                        }
                    }else{
                        if(board.board[startSquare.getX()+1][startSquare.getY()].getPiece() == null && !this.hasMoved()){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        // white player is capturing or black player is capturing
        if(this.isWhite()){
            if(endSquare.getX() == startSquare.getX() - 1 && (endSquare.getY() == startSquare.getY() - 1 || endSquare.getY() == startSquare.getY() + 1)){
                return true;
            }
        }else{
            if(endSquare.getX() == startSquare.getX() + 1 && (endSquare.getY() == startSquare.getY() - 1 || endSquare.getY() == startSquare.getY() + 1)){
                return true;
            }
        }
        return false;
    }
}
