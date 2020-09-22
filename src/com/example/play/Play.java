package com.example.play;

import com.example.board.Board;
import com.example.game.Game;
import com.example.player.Player;

public class Play {
    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player(true);
        Player player2 = new Player(false);

        game.startGame(player1, player2);
        game.getBoard().printBoard();

        System.out.println(game.getBoard().board[0][0].getPiece().canMove(game.getBoard(), game.getBoard().board[1][0], game.getBoard().board[4][0]));
    }
}
