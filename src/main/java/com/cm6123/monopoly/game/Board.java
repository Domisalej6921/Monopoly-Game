package com.cm6123.monopoly.game;

import java.util.List;
import java.util.Scanner;


public class Board {
    /**
     * Creates the Array that the board will be stored in.
     */
    private String[][] board;

    /**
     * Creates the Array that the board will be stored in.
     */
    private String[][] originalBoard;

    /**
     * Obtains the user's input for the board size and checks if it is valid.
     *
     * @param scanner is used for the program to grab the user's input
     * @return the user's input of the spaces on the board.
     */
    public static int boardInput(final Scanner scanner) {

        //Prompt the user to specify the size of the board
        System.out.print("Please enter the number of spaces you would like on the Monopoly board (between 10 & 50): \n");
        int userInput = scanner.nextInt();

        //Validate User Input
        while (userInput < 10 || userInput > 51) {
            System.out.println("\nInvalid input!Please enter a number between 10 and 50: \n");
            System.out.print("Please enter the number of spaces you would like on the Monopoly board (between 10 & 50): \n");
            userInput = scanner.nextInt();
        }

        int numOfSpaces = userInput;

        return numOfSpaces;
    }

    /**
     * Creates the board String[][] and prints it in the terminal.
     *
     * @param numOfSpaces number of spaces the user wants the monopoly board to have.
     * @param properties list of properties to be placed on the board.
     * @return the board to be used elsewhere in the program
     */
    public static String[][] boardCreation(final int numOfSpaces, final List<Properties> properties) {
        System.out.println("\nMonopoly Board: \n");

        // Define the dimensions of the board
        int rows = numOfSpaces / 2;
        int cols = numOfSpaces / 2;

        String[][] board = new String[rows][cols];

        // Fill the board with empty spaces
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = "           ";
            }
        }

        int propertyIndex = 0;
        // Print new property or class for each item around the edge of the array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    if (properties.isEmpty()) {
                        System.out.println("Error: Properties list is empty.");
                        return null;
                    } else {
                        board[i][j] = properties.get(propertyIndex).getPropertyName();
                        propertyIndex = (propertyIndex + 1) % properties.size();
                    }
                }
            }
        }

        // Add labels for special tiles
        board[0][0] = "   Home    ";

        String[][] originalBoard = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                originalBoard[i][j] = board[i][j];
            }
        }

        return board;
    }

    /**
     * Method to print the board when called.
     * @param board
     */
    public static void printBoard(final String[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    /**
     * Getter for originalBoard.
     *
     * @param board
     *
     * @return originalBoard
     */
    public static String[][] getOriginalBoard(final String[][] board) {
        String[][] originalBoard = board;
        return originalBoard;
    }

    /**
     * method to spawn a player at the Home space on the board.
     * @param board
     * @param x
     * @param y
     * @param searchIndex
     * @return the coords of where the player spawned at.
     */
    public static int[][] spawnPlayer(final String[][] board, final int x, final int y, final int searchIndex) {

        int[][] coords = new int[x][y];

        // Check if the coordinates are within the board's bounds
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            System.out.println("Invalid coordinates. Player cannot be spawned.");
            return null;
        }

        // Place the player symbol on the board
        String playerSymbol = "    P" + (searchIndex) + "     ";

        board[x][y] = playerSymbol;

        return coords;
    }
}
