package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
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
        // Create test data
        int numOfSpaces = 20;
        List<Properties> properties = Properties.getProperties(numOfSpaces);

        // Call the method to test
        String[][] board = Board.boardCreation(numOfSpaces, properties);

        // Check if the board is created correctly
        assertNotNull(board, "Board should not be null");
        assertEquals(numOfSpaces / 2, board.length, "Board rows should be correct");
        assertEquals(numOfSpaces / 2, board[0].length, "Board columns should be correct");

        // Check if the properties are assigned correctly to the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                    assertNotNull(board[i][j], "Property should not be null");
                } else {
                    assertEquals("           ", board[i][j], "Inner cells should be empty");
                }
            }
        }
    }
}
