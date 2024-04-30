package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.cm6123.monopoly.game.Board.boardCreation;
import static org.junit.jupiter.api.Assertions.*;


public class BoardChecks {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    public void testValidInput() {
        //Preparing input
        String input = "30";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        //Call the method
        int result = Board.boardInput(scanner);

        //Validate result
        assertEquals(30, result);
    }

    @Test
    public void testInvalidInputThenValidInput() {
        //Preparing input
        String input = "5\n60\n30";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        //Calling method
        int result = Board.boardInput(scanner);

        //Validating result
        assertEquals(30, result);
    }

    @Test
    public void testBoundaryInput() {
        //Preparing input
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        //Calling method
        int result = Board.boardInput(scanner);
        assertEquals(10, result);
    }

    @Test
    public void testBoardCreation() {
        // Defines the number of spaces for testing
        final int numOfSpaces = 10;

        // Call the method to create the board
        String[][] board = Board.boardCreation(numOfSpaces);

        // Define the expected board configuration for 10 spaces
        String[][] expectedBoard = {
                {"Home", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " "}
        };

        // Compare expected and actual boards
        if (board.length != expectedBoard.length || board[0].length != expectedBoard[0].length) {
            throw new AssertionError("Monopoly board creation test failed: boards have different dimensions.");
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].equals(expectedBoard[i][j])) {
                    throw new AssertionError("Monopoly board creation test failed at position [" + i + "][" + j + "].");
                }
            }
        }
    }
}
