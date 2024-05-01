package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.PlayerClass;

import java.util.Scanner;

public class PlayerProcessing {

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

        System.out.print("Please name each of the players: (" + playerCount + " -- One after the other.): \n");
        do {
            playerNames = playerNames + scanner.nextLine();
        } while (playerNames.isEmpty() || playerCount >= playerNames.length() - 1);

        //Prints the Players Names
        System.out.println("Player Names: \n" + playerNames + " \n");

        return playerNames;
    }

    /**
     * Handles the processing of player data.
     *
     * @param scanner allows user input.
     */
    private void playerProcessing(final int playerCount, final Class<?> player, final Scanner scanner) {

        for(int i = 0; i < playerCount; i++) {
            PlayerClass playerClass = new PlayerClass();
            playerClass.playerTurn(player, scanner);
        }
    }

    /**
     * Executes the processing of user data.
     *
     * @param scanner allows user to input data.
     */
    public static final void playerExecution(final Scanner scanner) {
        PlayerProcessing exe = new PlayerProcessing();
        int playerCount = exe.playerCounterInput(scanner);
        String playerNames = playerNameInput(playerCount, scanner);


        String className = "com.cm6123.monopoly.game.Player;";
        Class<?> players = null;
        for (int i = 0; i < playerCount; i++) {
            Player player = new Player(playerNames);
            try {

                players = Class.forName(className);
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + e.getMessage());
            }
        }


        exe.playerProcessing(playerCount, players, scanner);
    }
}
