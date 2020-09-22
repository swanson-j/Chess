package com.example.player;

import com.example.board.Board;
import com.example.square.Square;

import java.util.Iterator;
import java.util.Vector;

public class Player {
    private boolean isWhitePlayer;

    public Player(boolean isWhitePlayer){
        setWhitePlayer(isWhitePlayer);
    }

    public boolean isWhitePlayer(){
        return this.isWhitePlayer;
    }

    public void setWhitePlayer(boolean isWhitePlayer) {
        this.isWhitePlayer = isWhitePlayer;
    }

    public boolean canCheck(Board board, Square enemyKingSquare) {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.board[i][j].getPiece() != null){
                    if(board.board[i][j].getPiece().isWhite() == isWhitePlayer){
                        if(board.board[i][j].getPiece().canMove(board, board.board[i][j], enemyKingSquare)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
