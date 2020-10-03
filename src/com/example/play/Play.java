package com.example.play;

import com.example.board.Board;
import com.example.com.example.gameStatus.GameStatus;
import com.example.game.Game;
import com.example.piece.King;
import com.example.player.Player;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Scanner scan = new Scanner(System.in);

        Player player1 = new Player(true);
        Player player2 = new Player(false);

        game.newGame(player1, player2);
        game.getBoard().printBoard();

        game.setWhiteTurn(true);

        while(game.getStatus() == GameStatus.ACTIVE){
            int startX = 0;
            int startY = 0;
            int endX = 0;
            int endY = 0;

            System.out.print("Start X: ");
            startX = scan.nextInt();
            System.out.print("Start Y: ");
            startY = scan.nextInt();
            System.out.print("End X: ");
            endX = scan.nextInt();
            System.out.print("End Y: ");
            endY = scan.nextInt();

            if(game.getWhiteTurn()){
                if(!game.playerMove(player1, startX, startY, endX, endY))
                    continue;

                if(!game.MakeMove(player1, startX, startY, endX, endY))
                    continue;

                game.getBoard().printBoard();
                game.setWhiteTurn(false);
            }else{
                if(!game.playerMove(player2, startX, startY, endX, endY))
                    continue;

                if(!game.MakeMove(player2, startX, startY, endX, endY))
                    continue;

                game.getBoard().printBoard();
                game.setWhiteTurn(true);
            }
        }
    }
}
