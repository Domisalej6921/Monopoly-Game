package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;

import java.util.Arrays;
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
    public static void playerTurn(Scanner scanner, String[] playerNames) {

        String activePlayer = Player.getPlayerNames(playerNames);

        System.out.println("\nWelcome player " + activePlayer + " its your turn! \n");

        //Executes the rolling of the dice
        Dice dice = new Dice(6);
        System.out.println("Roll the pair of dice");
        int[] result = dice.rollTwoDice();

        //Checks if player rolled a double
        Boolean doubleRoll = dice.checkForDouble(result);
        if (doubleRoll == null) {
            System.out.println("You rolled " + result[0] + " and " + result[1] + "!");
        }
    }
}
