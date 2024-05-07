package com.cm6123.monopoly.game;

import java.util.HashMap;
import java.util.Map;

import static com.cm6123.monopoly.game.Board.getOriginalBoard;

public class Player {

    /**
     * Initialises player's name.
     */
    private static String playerName;

    /**
     * Initiates default balance value.
     */
    private static Map<String, Integer> playerBalances = new HashMap<>();

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
     * constructor for the player class.
     *
     * @param name
     */
    public Player(final String name) {
        this.playerName = name;
        this.playerBalances = playerBalances;
        this.x = 0;
        this.y = 0;
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
     * used to get player's name.
     * @param playerNames
     * @param searchIndex
     * @return the player's name depending on index.
     */
    public static String getPlayerName(final String[] playerNames, final int searchIndex) {
        if (searchIndex >= 0 && searchIndex < playerNames.length) {
            return playerNames[searchIndex];
        }
        // If the index is out of bounds, return null
        return null;
    }

    /**
     * used to get player's balance.
     * @return the player's balance.
     */
    public static int getBalance() {
        return playerBalances.getOrDefault(playerName, 1000);
    }

    /**
     * used to add balance to the player.
     * @param amount
     * @param activePlayerName
     */
    public static void addBalance(final String activePlayerName, final int amount) {
        int currentBalance = getBalance();
        playerBalances.put(activePlayerName, currentBalance + amount);
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
    public static String[][] movePlayer(final String[][] board, final int totalMove, final int searchIndex, final String activePlayer, final Player playerInstance) {
        int [] coords = new int[2];
        String playerSymbol = " P ";

        String[][] originalBoard = getOriginalBoard(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                playerSymbol = "     P" + (searchIndex + 1) + "    ";
                if (board[i][j].equals(playerSymbol)) { // If player's symbol is found
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
            addBalance(activePlayer, 200);
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

        return board;
    }

    /**
     * used to print the player's position on the board.
     * @param newX
     * @param newY
     * @param board
     */
    public static void printPlayerPosition(final int newX, final int newY, final String[][] board) {

        // Check if the coordinates are within the board's bounds
        if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) {
            System.out.println("Invalid coordinates. Player's position cannot be printed.");
            return;
        }

        //Get the player's current position
        int x = newX;
        int y = newY;

        String property = board[x][y];

        System.out.println("\nYou are currently at: " + property);
    }
}
