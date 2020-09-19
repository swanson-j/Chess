package com.example.piece;

import com.example.board.Board;
import com.example.square.Square;

public class Rook extends Piece{
    public Rook(boolean isWhite, boolean isCaptured){
        super(isWhite, isCaptured);
    }

    @Override
    public boolean canMove(Board board, Square startSquare, Square endSquare) {
        // rook cannot capture same colored piece
        if(endSquare.getPiece() != null){
            if(endSquare.getPiece().isWhite() == this.isWhite())
                return false;
        }

        int xMove = endSquare.getX() - startSquare.getX();
        int yMove = endSquare.getY() - startSquare.getY();

        // rook is not moving correctly
        if((xMove == 0 && yMove == 0) || (xMove != 0 && yMove != 0)){
            return false;
        }

        // check that no pieces are in the path of the rook
        if(xMove == 0){
            if(yMove > 0){
                for(int i = 1; i != yMove; i++){
                    if(board.board[startSquare.getX()][startSquare.getY()+i].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }else{
                for(int i = -1; i != yMove; i--){
                    if(board.board[startSquare.getX()][startSquare.getY()+i].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }
        }else if(yMove == 0){
            if(xMove > 0){
                for(int i = 1; i != xMove; i++){
                    if(board.board[startSquare.getX()+i][startSquare.getY()].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }else{
                for(int i = -1; i != xMove; i--){
                    if(board.board[startSquare.getX()+i][startSquare.getY()].getPiece() != null){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
