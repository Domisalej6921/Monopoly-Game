package com.cm6123.monopoly.game;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Board {
    /**
     * Creates the Array that the board will be stored in.
     */
    private Properties[][] board;

    /**
     * Creates the Array that the board will be stored in.
     */
    private Properties[][] originalBoard;

    /**
     * Creates the Array that the board will be stored in.
     */
    private static Map<Point, Properties> propertyMap = new HashMap<>();

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
     * @param properties  list of properties to be placed on the board.
     * @return the board to be used elsewhere in the program
     */
    public static Properties[][] boardCreation(final int numOfSpaces, final List<Properties> properties) {
        System.out.println("\nMonopoly Board: \n");

        // Define the dimensions of the board
        int rows = numOfSpaces / 2;
        int cols = numOfSpaces / 2;

        Properties[][] board = new Properties[rows][cols];

        // Add labels for special tiles
        Properties home = new Properties("   Home    ", PropertyType.Home, null, 0, 0);
        board[0][0] = home;

        int propertyIndex = 0;
        // Print new property or class for each item around the edge of the array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        if (properties.isEmpty()) {
                            System.out.println("Error: Properties list is empty.");
                            return null;
                        } else {
                            board[i][j] = properties.get(propertyIndex);
                            propertyIndex = (propertyIndex + 1) % properties.size();
                        }
                    }
                }
            }
        }

        // Fill the propertyMap
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    if (!properties.isEmpty()) {
                        propertyMap.put(new Point(i, j), properties.get(propertyIndex));
                        propertyIndex = (propertyIndex + 1) % properties.size();
                    }
                }
            }
        }

        Properties[][] originalBoard = new Properties[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                originalBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < originalBoard.length; i++) {
            for (int j = 0; j < originalBoard[i].length; j++) {
                if (originalBoard[i][j] != null) {
                    if (i == 0 && j == 0) {
                        System.out.print("|" + "   Home    " + "|");
                    } else {
                        Properties activeProperty = getPropertyAtCoords(i, j);
                        System.out.print("|" + activeProperty.getPropertyName(activeProperty) + "|");
                    }
                } else {
                    System.out.print("             ");
                }
            }
            System.out.println();
        }

        return board;
    }

    /**
     * Method to print the board when called.
     *
     * @param board
     * @param playerSymbol
     */
    public static void printBoard(final Properties[][] board, final Properties playerSymbol) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    if (i == 0 && j == 0) {
                        System.out.print("|" + "   Home    " + "|");
                    } else if(board[i][j].getPropertyType() == PropertyType.Player) {
                        System.out.print("|" + playerSymbol.getPropertyName(playerSymbol) + "|");
                    }else {
                        Properties activeProperty = getPropertyAtCoords(i, j);
                        System.out.print("|" + activeProperty.getPropertyName(activeProperty) + "|");
                    }
                } else {
                    System.out.print("             ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Getter for originalBoard.
     *
     * @param board
     * @return originalBoard
     */
    public static Properties[][] getOriginalBoard(final Properties[][] board) {
        Properties[][] originalBoard = board;
        return originalBoard;
    }

    /**
     * method to spawn a player at the Home space on the board.
     *
     * @param board
     * @param x
     * @param y
     * @param searchIndex
     * @return the coords of where the player spawned at.
     */
    public static int[][] spawnPlayer(final Properties[][] board, final int x, final int y, final int searchIndex) {

        int[][] coords = new int[x][y];

        // Check if the coordinates are within the board's bounds
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            System.out.println("Invalid coordinates. Player cannot be spawned.");
            return null;
        }

        Properties playerSymbol = new Properties("    P" + (searchIndex) + "     ", PropertyType.Player, null, 0, 0);
        board[x][y] = playerSymbol;

        return coords;
    }

    /**
     * Getter for propertyMap.
     * @param x
     * @param y
     *
     * @return propertyMap
     */
    public static Properties getPropertyAtCoords(final int x, final int y) {
        return propertyMap.get(new Point(x, y));
    }
}
