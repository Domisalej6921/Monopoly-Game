package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayerClass {

    /**
     * Initialises the player variable.
     */
    private Player playerActive;

    /**
     * Passes the player into the method which conducts the players turn.
     *
     * @param player
     * @param scanner
     */
    public static void playerTurn(Scanner scanner, String[] playerNames, int searchIndex, String[][] board) {

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

        String[][] updatedBoard = Player.movePlayer(board, totalMove);

        Board.printBoard(updatedBoard);
    }
}
