package com.example.game;

import com.example.board.Board;
import com.example.com.example.gameStatus.GameStatus;
import com.example.move.Move;
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
    }

    public boolean isGameOver(){
        return status != GameStatus.ACTIVE;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY){
        // TODO: playerMove checks if the player is moving correct colored piece
        // TODO: and to a legal square
    }

    public boolean MakeMove(){
        // TODO: makes move and calls causesSelfCheck to determine if it is legal.
        // TODO: if the move can be made, change STUFF
    }

    public boolean causesSelfCheck(Player player, Square startSquare, Square endSquare){
        //TODO: if player makes move, check that all enemy pieces cannot attack king
    }
    public void addMove(Move move){
        moves.add(move);
    }
}
