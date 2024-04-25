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
     *
     * @return the user's input of the spaces on the board.
     */
    public static int boardInput(final Scanner scanner) {

        //Prompt the user to specify the size of the board
        System.out.print("Please enter the number of spaces you would like on the Monopoly board (between 10 & 50): ");
        int userInput = scanner.nextInt();

        //Validate User Input
        while (userInput < 10 || userInput > 50) {
            System.out.println("Invalid input!Please enter a number between 10 and 50");
            System.out.print("Please enter the number of spaces you would like on the Monopoly board (between 10 & 50): ");
            userInput = scanner.nextInt();
        }

        int numOfSpaces = userInput;

        return numOfSpaces;
    }


    /**
     * This class creates a single card which can be inserted into the board.
     *
     * @return is used so that it returns the format of a card to be inserted on the board.
     */
    public static String createSpace() {
        StringBuilder cardBuilder = new StringBuilder();
        int width = 12; // Width of the pattern
        int height = 4; // Height of the pattern

        // Create the top border
        cardBuilder.append("+");
        for (int i = 0; i < width - 2; i++) {
            cardBuilder.append("-");
        }
        cardBuilder.append("+\n");

        // Create the middle part of space
        cardBuilder.append("|");
        for (int i = 0; i < width - 2; i++) {
            if (i == (width - 2) / 2 - 5) {
                cardBuilder.append("Space");
                i += 4;
            } else {
                cardBuilder.append(" ");
            }
        }
        cardBuilder.append("|\n");

        // Add a line of "-" below the property name
        cardBuilder.append("|");
        for (int i = 0; i < width - 2; i++) {
            cardBuilder.append("-");
        }
        cardBuilder.append("|\n");

        // Add a couple of lines of space below the word Space Name
        cardBuilder.append("|");
        for (int i = 0; i < width - 2; i++) {
            cardBuilder.append(" ");
        }
        cardBuilder.append("|\n");

        cardBuilder.append("|");
        for (int i = 0; i < width - 2; i++) {
            cardBuilder.append(" ");
        }
        cardBuilder.append("|\n");

        // Create the bottom border
        cardBuilder.append("+");
        for (int i = 0; i < width - 2; i++) {
            cardBuilder.append("-");
        }
        cardBuilder.append("+\n");

        return cardBuilder.toString();
    }

    /**
     * This class creates the board with the ammount of spaces that the user has specified.
     *
     * @param numOfSpaces is used so that it can create the board specific to how the user specified.
     *
     * @param cardBuiler is a single card that used in this function will be displayed on the board.
     */
    public static void boardCreation(final int numOfSpaces, final StringBuilder cardBuiler) {
        System.out.println("Monopoly Board: ");
        for (int i = 0; i < numOfSpaces; i++) {
            System.out.print(createSpace());
        }
    }
}
