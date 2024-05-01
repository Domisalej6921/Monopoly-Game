package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;

import java.util.Scanner;

import static com.cm6123.monopoly.dice.Dice.checkForDouble;

public class PlayerClass {

    /**
     * Initialises the player variable.
     */
    private Player playerActive;

    private void playerClass(final Player player) {
        this.playerActive = player;
    }
    /**
     * Passes the player into the method which conducts the players turn.
     *
     * @param player
     * @param scanner
     */
    public static void playerTurn(Object player, Scanner scanner) {
        System.out.println("Welcome player " + player + " its your turn!");

        Dice dice = new Dice(6);
        System.out.println("Roll the pair of dice");
        int[] result = dice.rollTwoDice();
        Boolean doubleRoll = dice.checkForDouble(result);


        if (doubleRoll == null) {
            System.out.println("You rolled " + result[0] + " and " + result[1] + "!");
        }
    }
}
