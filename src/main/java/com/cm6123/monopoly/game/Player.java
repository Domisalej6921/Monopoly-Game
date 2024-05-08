package com.cm6123.monopoly.game;

import com.cm6123.monopoly.dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.cm6123.monopoly.game.Board.getOriginalBoard;

public class Player {

    /**
     * Initialises player's name.
     */
    private String playerName;

    /**
     * Initiates default balance value.
     */
    private int balance = 1000;

    /**
     * Initialises player's assets.
     */
    private List<Properties> assets;

    /**
     * Initialises player x location on board.
     */
    private int x;

    /**
     * Initialises player y location on board.
     */
    private int y;

    /**
     * Initialises player's last x location on board.
     */
    private int lastX;

    /**
     * Initialises player's last y location on board.
     */
    private int lastY;

    /**
     * Initialises player's new x location on board.
     */
    private int newX;

    /**
     * Initialises player's new y location on board.
     */
    private int newY;

    /**
     * constructor for the player class.
     *
     * @param name
     */
    public Player(final String name) {
        this.playerName = name;
        this.assets = new ArrayList<>();
        this.x = 0;
        this.y = 0;
    }

    /**
     * used to get player's assets.
     * @param currentPlayer
     * @return the player's assets.
     */
    public String getPlayerAssests() {
        if (this.assets.isEmpty()) {
            return "You do not have any Properties.";
        } else {
            StringBuilder assetsList = new StringBuilder();
            for (Properties property : this.assets) {
                assetsList.append(Properties.getPropertyName(property)).append("\n");
            }
            return "Your properties: \n" + assetsList;
        }
    }

    /**
     * used to get player's X location.
     * @return last x
     */
    public int getLastX() {
        return lastX;
    }

    /**
     * used to get player's Y location.
     * @return last y
     */
    public int getLastY() {
        return lastY;
    }

    /**
     * used to get player's X location.
     * @return x.
     */
    public int getX() {
        return x;
    }

    /**
     * used to get player's Y location.
     * @return y.
     */
    public int getY() {
        return y;
    }

    /**
     * used to get player's new X location.
     * @return newX
     */
    public int getNewX() {
        return this.newX;
    }

    /**
     * used to get player's new Y location.
     * @return newY
     */
    public int getNewY() {
        return this.newY;
    }

    /**
     * used to get player's name.
     * @return the player's name depending on index.
     */
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * used to get player's balance.
     * @param currentPlayer
     * @return the player's balance.
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * used to add balance to the player.
     * @param amount
     * @param activePlayerName
     */
    public void addBalance(final String activePlayerName, final int amount) {
        this.balance = this.balance + amount;
        System.out.println(activePlayerName + "'s balance is now: " + this.balance);
    }

    /**
     * Sets the player's balance.
     *
     * @param currentBalance the new balance
     */
    public void setBalance(final int currentBalance) {
        this.balance = currentBalance;
    }

    /**
     * used to remove balance from the player.
     *
     * @param property
     *
     */
    public void addPropertyToAssets(final Properties property) {
        // Assuming assets is a List of Property
        this.assets.add(property);
    }

    /**
     * used to move the player around the board String[][].
     * @param board
     * @param totalMove
     * @param searchIndex
     * @param activePlayer
     * @param playerInstance
     * @return old board.
     */
    public static Properties[][] movePlayer(final Properties[][] board, final int totalMove, final int searchIndex, final String activePlayer, final Player playerInstance) {
        int [] coords = new int[2];
        Properties playerSymbol = new Properties("    P" + (searchIndex) + "     ", PropertyType.Player, null, 0, 0);

        Properties[][] originalBoard = getOriginalBoard(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null && board[i][j].equals(playerSymbol)) { // If player's symbol is found
                    coords[0] = i;
                    coords[1] = j;
                }
            }
        }

        int x = coords[0];
        int y = coords[1];

        // Calculate new player position based on totalMove
        int totalSpaces = 2 * (board.length + board[0].length);

        //Calculate current position and new position
        int currentPosition = x + y;
        if (x == 0) {
            currentPosition = y;
        } else if (y == board[0].length - 1) {
            currentPosition = board[0].length + x;
        } else if(x == board.length - 1) {
            currentPosition = board.length + board[0].length + (board[0].length - y - 1);
        } else if (y == 0) {
            currentPosition = totalSpaces - x;
        }

        int newPosition = (currentPosition + totalMove) % totalSpaces;

        int oldPosition = currentPosition;
        if (newPosition < oldPosition) {
            playerInstance.addBalance(activePlayer, 200);
        }

        //Convert new position back to 2D coordinates
        if (newPosition < board[0].length) {
            x = 0;
            y = newPosition;
        } else if (newPosition < board[0].length + board.length) {
            x = newPosition - board[0].length;
            y = board[0].length - 1;
        } else if (newPosition < 2 * board[0].length + board.length) {
            x = board.length - 1;
            y = 2 * board[0].length + board.length - newPosition - 1;
        } else {
            x = totalSpaces - newPosition;
            y = 0;
        }

        Player.printPlayerPosition(x, y, board);

        // Restore the board to its original state
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == playerInstance.lastX && j == playerInstance.lastY) {
                    board[i][j] = originalBoard[i][j];
                } else if (!(i == playerInstance.x && j == playerInstance.y)) {
                    board[i][j] = originalBoard[i][j];
                }
            }
        }

        //Update Player Position
        board[x][y] = playerSymbol;

        playerInstance.lastX = playerInstance.x;
        playerInstance.lastY = playerInstance.y;

        playerInstance.x = x;
        playerInstance.y = y;

        //Player.printPlayerPosition(x, y, board);

        return board;
    }

    /**
     * used to print the player's position on the board.
     * @param newX
     * @param newY
     * @param board
     *
     * @return the player's position.
     */
    public static Properties printPlayerPosition(final int newX, final int newY, final Properties[][] board) {

        // Check if the coordinates are within the board's bounds
        if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
            System.out.println("Invalid coordinates. Player's position cannot be printed.");
            return null;
        }

        //Get the player's current position
        int x = newX;
        int y = newY;

        Properties property = board[x][y];

        if(x == 0 && y == 0) {
            System.out.println("You are currently at Home.");
        } else if(!(x == 0 && y == 0)) {
            if(property != null) {
                System.out.println("\nYou are currently at: " + property.getPropertyName(property));
            } else {
                System.out.println("You are currently at an empty space.");
            }
        }
        return property;
    }

    /**
     * Initialises the checks if a property is purchased.
     *
     * @param property
     * @param scanner
     * @param diceResult
     */
    public void checkForPropertyPurchase(final Properties property, final Scanner scanner, final int[] diceResult) {
        if (property == null) {
            System.out.println("Error: The property you have landed on doesn't exist.");
            return;
        }

        if (property.getPropertyType() == PropertyType.Property) {
            System.out.println("You have landed on a property. Would you like to purchase it? (yes/no)");
            if (scanner.hasNextLine()) {
                String response = scanner.nextLine();


                if (response.equalsIgnoreCase("yes")) {
                    if (this.getBalance() >= property.getPrice()) {
                        this.setBalance(this.getBalance() - property.getPrice());
                        this.addPropertyToAssets(property);
                        System.out.println("You have successfully purchased the property.");
                    } else {
                        System.out.println("You do not have enough money to purchase this property.");
                    }
                }
            }
        } else if(property.getPropertyType() == PropertyType.Station) {
            int unitPrice = property.getPrice(); // Assuming getPrice() returns the unit price for a station
            int ticketPrice = (diceResult[0] + diceResult[1]) * unitPrice;

            if (this.getBalance() >= ticketPrice) {
                this.setBalance(this.getBalance() - ticketPrice);
                System.out.println("You have successfully paid for your travel. Your balance is now: " + this.getBalance());
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
     * @param dice
     */
    public void playerTurn(final Scanner scanner, final String[] playerNames, final int searchIndex, final Properties[][] board, final Dice dice) {

        String activePlayer = this.getPlayerName();

        int numOfSpaces = board[0].length + board[1].length;

        System.out.println("\n\nWelcome " + activePlayer + " its your turn! \n");

        Properties playerSymbol = new Properties("    P" + (searchIndex + 1) + "     ", PropertyType.Player, null, 0, 0);

        board[this.getLastX()][this.getLastY()] = playerSymbol;
        Board.printBoard(board, playerSymbol);

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
            board[this.getLastX()][this.getLastY()] = playerSymbol;

            Properties[][] updatedBoard = Player.movePlayer(board, totalMove, searchIndex, activePlayer, this);
            Board.printBoard(updatedBoard, playerSymbol);

            System.out.println("\nYour Balance is: " + this.getBalance());

            Properties landedProperty = Board.getPropertyAtCoords(this.getNewX(), this.getNewY());
            checkForPropertyPurchase(landedProperty, scanner, result);

            System.out.println(this.getPlayerAssests());
        }
    }
}
