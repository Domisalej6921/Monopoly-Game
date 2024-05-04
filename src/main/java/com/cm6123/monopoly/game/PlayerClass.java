package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;

import java.util.Scanner;

public class PlayerClass {

    /**
     * Initialises the player variable.
     */
    private Player playerActive;

    /**
     * Passes the player into the method which conducts the players turn.
     *
     * @param scanner
     * @param playerNames
     * @param searchIndex
     * @param board
     */
    public static void playerTurn(final Scanner scanner, final String[] playerNames, final int searchIndex, final String[][] board) {

        String activePlayer = Player.getPlayerName(playerNames, searchIndex);

        System.out.println("Welcome " + activePlayer + " its your turn! \n");

        Board.printBoard(board);

        System.out.println("Press enter to continue your turn...");
        scanner.nextLine();

        //Executes the rolling of the dice
        Dice dice = new Dice(6);
        int[] result = dice.rollTwoDice();

        //Checks if player rolled a double
        Boolean doubleRoll = dice.checkForDouble(result);
        if (doubleRoll == null) {
            System.out.println("\nYou rolled " + result[0] + " and " + result[1] + "!\n");
        }

        int totalMove = result[0] + result[1];

        String[][] updatedBoard = Player.movePlayer(board, totalMove, searchIndex);

        Board.printBoard(updatedBoard);
    }
}
