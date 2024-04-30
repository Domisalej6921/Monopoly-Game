package com.cm6123.monopoly.game;

import java.util.Scanner;


public class Player {

    /**
     * Initiates default player values.
     */
    private int balance = 0;

    /**
     *
     * Finds how many players are in the game.
     *
     * @param scanner allows user to input data
     *
     * @return the amount of players in game.
     */
    public static int playerCounterInput(final Scanner scanner) {

        System.out.print("Please enter the amount of Players (Between 2 and 10): ");
        int input = scanner.nextInt();


        //Validate User Input
        while (input < 2 || input > 11) {
            System.out.println("Invalid input!Please enter a number between 2 and 10.");
            System.out.print("Please enter the amount of Players (Between 2 and 10): ");
            input = scanner.nextInt();
        }

        int playerCount= input;

        //Test Code to see Output
        System.out.println("You have " + playerCount + " players!");

        scanner.close();

        return playerCount;
    }
}
