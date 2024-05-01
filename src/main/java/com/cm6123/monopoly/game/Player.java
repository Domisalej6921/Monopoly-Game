package com.cm6123.monopoly.game;

import java.util.Scanner;


public class Player {

    /**
     * Initialises player's name.
     */
    private String playerName;

    /**
     * Initiates default balance value.
     */
    private int balance;

    /**
     * constructor for the player class.
     * @param name
     */
    public Player(final String name) {
        this.playerName = name;
        this.balance = 1000;
    }

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

        return playerCount;
    }

    /**
     *
     * This method gets the name of each player that is playing the game.
     *
     * @param playerCount is the number of players in the session
     * @param scanner used to get input
     * @return the names of each player
     */
    public static String playerNameInput(final int playerCount, final Scanner scanner) {

        String playerNames = "";

        int count = playerCount;

        do {
            System.out.print("Please name each of the players: (" + playerCount + " -- One after the other.): \n");
            playerNames = scanner.nextLine();
        } while (playerNames.isEmpty());

        //Prints the Players Names
        System.out.println("Player Names: \n" + playerNames);

        return playerNames;
    }
}
