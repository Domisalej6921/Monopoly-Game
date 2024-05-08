package com.cm6123.monopoly.app;

import com.cm6123.monopoly.dice.Dice;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Properties;

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

        System.out.print("\nPlease enter the amount of Players (Between 2 and 10): \n");
        int input = scanner.nextInt();


        //Validate User Input
        while (input < 2 || input > 10) {
            System.out.println("\nInvalid input!Please enter a number between 2 and 10:  \n");
            input = scanner.nextInt();
        }

        int playerCount= input;

        //Test Code to see Output
        System.out.println("\nYou have " + playerCount + " players! \n");

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
    public static String[] playerNameInput(final int playerCount, final Scanner scanner) {

        String[] playerNames = new String[playerCount];

        System.out.print("\nPlease name each of the players: (" + playerCount + " -- One after the other.): \n");

        // Fill the array with usernames
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Enter username #" + (i + 1) + ": ");
            do {
                playerNames[i] = scanner.nextLine().trim();
            } while (playerNames[i].isEmpty());
        }

        return playerNames;
    }

    /**
     * Obtains the user's input for the number of rounds and checks if it is valid.
     *
     * @param scanner is used for the program to grab the user's input
     * @return the user's input of the number of rounds.
     */
    public static int roundInput(final Scanner scanner) {
        System.out.print("\n\nPlease enter the number of rounds you would like to play: \n");
        int roundInput = scanner.nextInt();

        // Validate User Input
        while (roundInput <= 0) {
            System.out.println("\nInvalid input! Please enter a positive number: \n");
            System.out.print("Please enter the number of rounds you would like to play: \n");
            roundInput = scanner.nextInt();
        }

        return roundInput;
    }

    /**
     * Executes the processing of user data.
     *
     * @param scanner allows user to input data.
     * @param board
     */
    public static final void playerExecution(final Scanner scanner, final Properties[][] board) {
        int playerCount = playerCounterInput(scanner);
        String[] playerNames = playerNameInput(playerCount, scanner);
        boolean gameFinished = false;
        int roundCount = roundInput(scanner);
        int currentRound = 0;

        Player[] players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }

        //Spawning players on the board
        for (int i = 0; i < playerCount; i++) {
            int searchIndex = i;
            Board.spawnPlayer(board, 0, 0, searchIndex);
        }

        //Game Loop
        while (!gameFinished) {
            for (int i = 0; i < playerCount; i++) {
                int searchIndex = i;
                Player currentPlayer = players[i];
                boolean playerStatus = currentPlayer.playerTurn(scanner, playerNames, searchIndex, board, new Dice(6));

                if (!playerStatus) {
                    gameFinished = true;
                    break;
                }
            }

            currentRound++;

            if (gameFinished || currentRound == roundCount) {
                System.out.println("Game Over! Rounds has been completed!");

                //Find player with the highest balance and make them winner
                Player winner = players[0];
                String winnerName = playerNames[0];
                for (int i = 1; i < playerCount; i++) {
                    if (players[i].getBalance() > winner.getBalance()) {
                        winner = players[i];
                        winnerName = playerNames[i];
                        System.out.println("The winner is: " + winnerName + " with a balance of " + winner.getBalance() + "!");
                    } else if (players[i].getBalance() == winner.getBalance()) {
                        System.out.println("It's a tie!");
                    } else {
                        System.out.println("No winner!");
                    }
                }
            } else {
                System.out.println("Round " + currentRound + " has been completed!");
            }
        }
    }
}
