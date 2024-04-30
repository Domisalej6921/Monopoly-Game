/**
 * Contains console classes for the user interface.
 * You do not need to write automated tests of classes/methods in this package.
 * DO NOT HIDE business logic in this package.
 */
package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Player;

import java.util.Scanner;

/**
 * This class handles the processing of the Game Board.
 */
class BoardProcessing {
    /**
     * This default constructor handles with the initial proccessing of the board when the user specifies the sixe of the board they want.
     */
     private void boardProcessing() {
        Scanner scanner1 = new Scanner(System.in);

        int numOfSpaces = Board.boardInput(scanner1);

        Board.boardCreation(numOfSpaces);

    }

    /**
     * This method executes the initial processing of the Game Board.
     */
    public static final void boardExecution() {
         BoardProcessing exe = new BoardProcessing();
         exe.boardProcessing();
    }
}

class PlayerProcessing {

    private void playerProcessing() {

        int playerCount = Player.playerInput();

    }

    public static final void playerExecution() {

        PlayerProcessing exe = new PlayerProcessing();
        exe.playerProcessing();
    }
}
