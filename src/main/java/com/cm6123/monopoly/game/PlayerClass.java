package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;

import java.util.Scanner;

public class PlayerClass {

    /**
     * Initialises the player variable.
     */
    private Player playerActive;

    /**
     * Initialises the checks if a property is purchased.
     *
     * @param currentPlayer
     * @param property
     * @param scanner
     * @param diceResult
     */
    public static void checkForPropertyPurchase(final Player currentPlayer, final Properties property, final Scanner scanner, final int[] diceResult) {
        if (property == null) {
            System.out.println("Error: The property you have landed on doesn't exist.");
            return;
        }

        if (property.getPropertyType() == PropertyType.Property) {
            System.out.println("You have landed on a property. Would you like to purchase it? (yes/no)");
            if (scanner.hasNextLine()) {
                String response = scanner.nextLine();


                if (response.equalsIgnoreCase("yes")) {
                    if (currentPlayer.getBalance(currentPlayer) >= property.getPrice()) {
                        currentPlayer.setBalance(currentPlayer.getBalance(currentPlayer) - property.getPrice());
                        currentPlayer.addPropertyToAssets(property);
                        System.out.println("You have successfully purchased the property.");
                    } else {
                        System.out.println("You do not have enough money to purchase this property.");
                    }
                }
            }
        } else if(property.getPropertyType() == PropertyType.Station) {
            int unitPrice = property.getPrice(); // Assuming getPrice() returns the unit price for a station
            int ticketPrice = (diceResult[0] + diceResult[1]) * unitPrice;

            if (currentPlayer.getBalance(currentPlayer) >= ticketPrice) {
                currentPlayer.setBalance(currentPlayer.getBalance(currentPlayer) - ticketPrice);
                System.out.println("You have successfully paid for your travel. Your balance is now: " + currentPlayer.getBalance(currentPlayer));
            } else {
                System.out.println("You do not have enough money to pay for this travel.");
            }
        }else {
            System.out.println("You have landed on " + property.getPropertyType() + ". You cannot purchase this.");
        }
    }

    /**
     * Passes the player into the method which conducts the players turn.
     *
     * @param scanner
     * @param playerNames
     * @param searchIndex
     * @param board
     * @param currentPlayer
     * @param dice
     */
    public static void playerTurn(final Scanner scanner, final String[] playerNames, final int searchIndex, final String[][] board, final Player currentPlayer, final Dice dice) {

        String activePlayer = currentPlayer.getPlayerName(playerNames, searchIndex);

        int numOfSpaces = board[0].length + board[1].length;

        System.out.println("\n\nWelcome " + activePlayer + " its your turn! \n");

        board[currentPlayer.getLastX()][currentPlayer.getLastY()] = "    P" + (searchIndex + 1) + "     ";
        Board.printBoard(board);

        System.out.println("Press enter to continue your turn...");
        if (scanner.hasNextLine()) {
            scanner.nextLine();

            int[] result = dice.rollTwoDice();

            //Checks if player rolled a double
            Boolean doubleRoll = dice.checkForDouble(result);
            System.out.println("\nYou rolled " + result[0] + " and " + result[1] + "!\n");
            if (doubleRoll) {
                System.out.println("You rolled a double! Congrats\n");
            }

            int totalMove = result[0] + result[1];

            // Update the player's position
            board[currentPlayer.getLastX()][currentPlayer.getLastY()] = "    P" + (searchIndex + 1) + "     ";

            String[][] updatedBoard = Player.movePlayer(board, totalMove, searchIndex, activePlayer, currentPlayer);

            Board.printBoard(updatedBoard);

            System.out.println("\nYour Balance is: " + currentPlayer.getBalance(currentPlayer));

            Properties landedProperty = Board.getPropertyAtCoords(currentPlayer.getNewX(currentPlayer), currentPlayer.getNewY(currentPlayer));
            checkForPropertyPurchase(currentPlayer, landedProperty, scanner, result);

            System.out.println(Player.getPlayerAssests(currentPlayer));
        }
    }
}
