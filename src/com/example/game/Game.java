package com.example.game;

import com.example.board.Board;
import com.example.move.Move;
import com.example.player.Player;

import java.util.List;

public class Game {
    private Board board;
    private Player[] players;
    private List<Move> moves;

    public Game(){
        board = new Board();
        players = new Player[2];
    }

    public Board getBoard(){
        return this.board;
    }

    public void startGame(Player player1, Player player2){
        board.reset();
        players[0] = player1;
        players[1] = player2;
    }
}
