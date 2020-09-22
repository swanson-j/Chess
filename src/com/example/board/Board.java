package com.example.board;

import com.example.piece.*;
import com.example.square.Square;

public class Board {
    public Square[][] board = new Square[8][8];

    public Board(){
        this.reset();
    }

    public Square getSquare(int x, int y) throws Exception {
        if(x < 0 || x > 7 || y < 0 || y > 7){
            throw new Exception("Not a proper square");
        }
        return board[x][y];
    }

    public void reset(){
        // set black major pieces
        board[0][0] = new Square(0,0, new Rook(false, false));
        board[0][1] = new Square(0,1, new Knight(false,false));
        board[0][2] = new Square(0,2, new Bishop(false, false));
        board[0][3] = new Square(0,3, new Queen(false,false));
        board[0][4] = new Square(0,4, new King(false, false));
        board[0][5] = new Square(0,5, new Bishop(false,false));
        board[0][6] = new Square(0,6, new Knight(false,false));
        board[0][7] = new Square(0,7, new Rook(false, false));

        // set black pawns
        for(int i = 0; i < 8; i++){
            board[1][i] = new Square(1,i, new Pawn(false,false));
        }

        // set white pawns
        for(int i = 0; i < 8; i++){
            board[6][i] = new Square(6,i, new Pawn(true,false));
        }

        // set white major pieces
        board[7][0] = new Square(7,0, new Rook(true, false));
        board[7][1] = new Square(7,1, new Knight(true,false));
        board[7][2] = new Square(7,2, new Bishop(true, false));
        board[7][3] = new Square(7,3, new Queen(true,false));
        board[7][4] = new Square(7,4, new King(true, false));
        board[7][5] = new Square(7,5, new Bishop(true,false));
        board[7][6] = new Square(7,6, new Knight(true,false));
        board[7][7] = new Square(7,7, new Rook(true, false));

        // set all other squares
        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Square(i,j, null);
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < 8; i++){
            for(int j =0; j < 8; j++){
                if(this.board[i][j].getPiece() instanceof Knight){
                    System.out.print("N");
                }
                if(this.board[i][j].getPiece() instanceof Bishop){
                    System.out.print("B");
                }
                if(this.board[i][j].getPiece() instanceof Rook){
                    System.out.print("R");
                }
                if(this.board[i][j].getPiece() instanceof Queen){
                    System.out.print("Q");
                }
                if(this.board[i][j].getPiece() instanceof King){
                    System.out.print("K");
                }
                if(this.board[i][j].getPiece() instanceof Pawn){
                    System.out.print("P");
                }
                if(this.board[i][j].getPiece() == null){
                    System.out.print("E");
                }
            }
            System.out.println();
        }
    }
}
