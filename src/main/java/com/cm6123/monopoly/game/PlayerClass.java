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
    public static void playerTurn(final Scanner scanner, final String[] playerNames, final int searchIndex, final String[][] board, final Player currentPlayer) {

        String activePlayer = currentPlayer.getPlayerName(playerNames, searchIndex);

        System.out.println("\n\nWelcome " + activePlayer + " its your turn! \n");

        board[currentPlayer.lastX][currentPlayer.lastY] = " P" + (searchIndex + 1) + " ";
        Board.printBoard(board);

        System.out.println("Press enter to continue your turn...");
        scanner.nextLine();

        //Executes the rolling of the dice
        Dice dice = new Dice(6);
        int[] result = dice.rollTwoDice();

        //Checks if player rolled a double
        Boolean doubleRoll = dice.checkForDouble(result);
        System.out.println("\nYou rolled " + result[0] + " and " + result[1] + "!\n");
        if (doubleRoll == true) {
            System.out.println("You rolled a double! Congrats\n");
        }

        int totalMove = result[0] + result[1];

        // Update the player's position
        board[currentPlayer.lastX][currentPlayer.lastY] = " P" + (searchIndex + 1) + " ";

        String[][] updatedBoard = Player.movePlayer(board, totalMove, searchIndex, activePlayer, currentPlayer);

        Board.printBoard(updatedBoard);


        System.out.println("\nYour Balance is: " + Player.getBalance(activePlayer));
        System.out.println("\nYour at");
    }
}
