package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Board;

import java.util.Scanner;

/**
 * This class handles the processing of the Game Board.
 */
public class BoardProcessing {

    /**
     * This default constructor handles with the initial proccessing of the board when the user specifies the sixe of the board they want.
     *
     * @param scanner allows user to input data
     */
    private void boardProcessing(final Scanner scanner) {

        int numOfSpaces = Board.boardInput(scanner);

        Board.boardCreation(numOfSpaces);

    }

    /**
     * This method executes the initial processing of the Game Board.
     *
     * @param scanner allows user to input data
     */
    public static final void boardExecution(final Scanner scanner) {
        BoardProcessing exe = new BoardProcessing();
        exe.boardProcessing(scanner);
    }
}
