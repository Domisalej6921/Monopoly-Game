/**
 * Contains console classes for the user interface.
 * You do not need to write automated tests of classes/methods in this package.
 * DO NOT HIDE business logic in this package.
 */
package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Board;
import java.util.Scanner;

/**
 * This class handles the processing of the Game Board.
 */
class BoardProcessing {
    /**
     * This default constructor handles with the initial proccessing of the board when the user specifies the sixe of the board they want.
     */
     private void boardProcessing() {
        Scanner scanner = new Scanner(System.in);

        int numOfSpaces = Board.boardInput(scanner);

        StringBuilder cardBuilder = new StringBuilder(Board.createSpace());

        Board.boardCreation(numOfSpaces, cardBuilder);

        scanner.close();
    }

    /**
     * This method executes the initial processing of the Game Board.
     */
    public static final void boardExecution() {
         BoardProcessing exe = new BoardProcessing();
         exe.boardProcessing();
    }
}



