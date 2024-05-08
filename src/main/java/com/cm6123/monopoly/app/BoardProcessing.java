package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Properties;

import java.util.Scanner;

/**
 * This class handles the processing of the Game Board.
 */
public class BoardProcessing {

    /**
     * Initialises the board variable.
     */
    private Properties[][] board;

    /**
     * This default constructor handles with the initial proccessing of the board when the user specifies the sixe of the board they want.
     *
     * @param scanner allows user to input data
     * @return the board when finsihed processing.
     */
    public Properties[][] boardProcessing(final Scanner scanner) {

        int numOfSpaces = Board.boardInput(scanner);

        Properties[][] localBoard = Board.boardCreation(numOfSpaces, Properties.getProperties(numOfSpaces));

        return localBoard;
    }

    /**
     * This method executes the initial processing of the Game Board.
     *
     * @param scanner allows user to input data
     * @return board after execution.
     */
    public static final Properties[][] boardExecution(final Scanner scanner) {
        BoardProcessing exe = new BoardProcessing();
        Properties[][] board = exe.boardProcessing(scanner);
        return board;
    }
}
