package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Board;

import java.util.Scanner;

/**
 * This class handles the processing of the Game Board.
 */
public class BoardProcessing {

    /**
     * Initialises the board variable.
     */
    private String[][] board;

    /**
     * This default constructor handles with the initial proccessing of the board when the user specifies the sixe of the board they want.
     *
     * @param scanner allows user to input data
     */
    public String[][] boardProcessing(final Scanner scanner) {

        int numOfSpaces = Board.boardInput(scanner);

        String[][] board = Board.boardCreation(numOfSpaces);

        return board;
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
