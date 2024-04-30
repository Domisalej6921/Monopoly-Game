package com.cm6123.monopoly.game;

import java.util.Scanner;


public class Board {
    /**
     * Creates the Array that the board will be stored in.
     */
    private String[] board;

    /**
     * Obtains the user's input for the board size and checks if it is valid.
     *
     * @param scanner is used for the program to grab the user's input
     * @return the user's input of the spaces on the board.
     */
    public static int boardInput(final Scanner scanner) {

        //Prompt the user to specify the size of the board
        System.out.print("Please enter the number of spaces you would like on the Monopoly board (between 10 & 50): ");
        int userInput = scanner.nextInt();

        //Validate User Input
        while (userInput < 10 || userInput > 51) {
            System.out.println("Invalid input!Please enter a number between 10 and 50");
            System.out.print("Please enter the number of spaces you would like on the Monopoly board (between 10 & 50): ");
            userInput = scanner.nextInt();
        }

        int numOfSpaces = userInput;

        return numOfSpaces;
    }

    /**
     * Creates the board String[][] and prints it in the terminal.
     *
     * @param numOfSpaces number of spaces the user wants the monopoly board to have.
     *
     * @return the board to be used elsewhere in the program
     */
    public static String[][] boardCreation(final int numOfSpaces) {
        System.out.println("Monopoly Board: ");

        // Define the dimensions of the board
        int rows = numOfSpaces / 2;
        int cols = numOfSpaces / 2;

        String[][] board = new String[rows][cols];

        // Fill the board with empty spaces
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = " ";
            }
        }

        // Add labels for special tiles
        board[0][0] = "GO";

        // Print the Monopoly board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        return board;
    }
}
