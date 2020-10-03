package com.example.game;

import com.example.board.Board;
import com.example.com.example.gameStatus.GameStatus;
import com.example.move.Move;
import com.example.piece.King;
import com.example.piece.Piece;
import com.example.player.Player;
import com.example.square.Square;

import java.util.List;

public class Game {
    private Board board;
    private Player[] players;
    private List<Move> moves;
    private GameStatus status;
    private boolean whiteTurn;


    public Game(){
        board = new Board();
        players = new Player[2];
        setWhiteTurn(true);
    }

    public boolean getWhiteTurn(){
        return whiteTurn;
    }

    public void setWhiteTurn(boolean whiteTurn){
        this.whiteTurn = whiteTurn;
    }

    public Board getBoard(){
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameStatus getStatus(){
        return status;
    }

    public void setStatus(GameStatus status){
        this.status = status;
    }

    public void newGame(Player player1, Player player2){
        board.reset();
        players[0] = player1;
        players[1] = player2;
        setWhiteTurn(true);
        setStatus(GameStatus.ACTIVE);
    }

    public boolean isGameOver(){
        return status != GameStatus.ACTIVE;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY){
        if(board.board[startX][startY].getPiece() == null){
            return false;
        }
        if(player.isWhitePlayer() != board.board[startX][startY].getPiece().isWhite()){
            return false;
        }

        if(board.board[startX][startY].getPiece().canMove(board, board.board[startX][startY],board.board[endX][endY])){
            return true;
        }

        return false;
    }

    public boolean MakeMove(Player player, int startX, int startY, int endX, int endY){
        Piece[] pieces = new Piece[2];
        pieces[0] = board.board[startX][startY].getPiece();
        pieces[1] = board.board[endX][endY].getPiece();

        board.board[endX][endY].setPiece(board.board[startX][startY].getPiece());
        board.board[startX][startY].setPiece(null);

        if(causesSelfCheck(player)){
            board.board[startX][startY].setPiece(pieces[0]);
            board.board[endX][endY].setPiece(pieces[1]);
            return false;
        }

        return true;
    }

    public boolean causesSelfCheck(Player player){
        int kingX = 0;
        int kingY = 0;

        // Find players king
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.board[i][j].getPiece() instanceof King) {
                    if(player.isWhitePlayer() == board.board[i][j].getPiece().isWhite()){
                        kingX = i;
                        kingY = j;
                    }
                }
            }
        }

        //for all enemy pieces, check if the piece can attack the player's king
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board.board[i][j].getPiece() != null){
                    if(player.isWhitePlayer() != board.board[i][j].getPiece().isWhite()){
                        if(board.board[i][j].getPiece().canMove(board, board.board[i][j], board.board[kingX][kingY])){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean isChecked(Player player, Square kingSquare){
        //TODO: check if the other player can move any pieces to the player's king
        return true;
    }

    public boolean isCheckMated(Player player, Square kingSquare){
        //TODO: if player is in check, check if the player can escape the check

        return true;
    }

    public void addMove(Move move){
        moves.add(move);
    }
}
