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
        if(Math.abs(xMove) != Math.abs(yMove) || xMove == 0 || yMove == 0){
            return false;
        }

        // check that no pieces are contained within the path of the bishop
        if(xMove > 0){
            if(yMove > 0){
                for(int i = 1; i != xMove; i++){
                    if(board.board[startSquare.getX()+i][startSquare.getY()+i].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }else{
                for(int i = 1; i != xMove; i++){
                    if(board.board[startSquare.getX()+i][startSquare.getY()-i].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }
        }else{
            if(yMove > 0){
                for(int i = -1; i != xMove; i--){
                    if(board.board[startSquare.getX()+i][startSquare.getY()-i].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }else{
                for(int i = -1; i != xMove; i--){
                    if(board.board[startSquare.getX()+i][startSquare.getY()+i].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
