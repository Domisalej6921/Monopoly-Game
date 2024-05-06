package com.cm6123.monopoly.game;

import java.util.HashMap;
import java.util.Map;

public class Player {

    /**
     * Initialises player's name.
     */
    private static String[] playerName;

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

    public int lastX;

    public int lastY;

    /**
     * constructor for the player class.
     *
     * @param name
     */
    public Player(final String[] name) {
        this.playerName = name;
        for (String playerName : name) {
            playerBalances.put(playerName, 1000);
        }
        this.x = 0;
        this.y = 0;
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

    public static int getBalance(final String playerName) {
        return playerBalances.getOrDefault(playerName, 1000);
    }

    public static void addBalance(final String playerName, final int amount) {
        int currentBalance = getBalance(playerName);
        playerBalances.put(playerName, currentBalance + amount);
    }


    /**
     * used to move the player around the board String[][].
     * @param board
     * @param totalMove
     * @param searchIndex
     * @return old board.
     */
    public static String[][] movePlayer(final String[][] board, final int totalMove, final int searchIndex, final String activePlayer, final Player playerInstance) {
        int [] coords = new int[2];
        String playerSymbol = " P ";
        playerInstance.lastX = playerInstance.x;
        playerInstance.lastY = playerInstance.y;


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                playerSymbol = " P" + (searchIndex + 1) + " ";
                if (board[i][j].equals(playerSymbol)) { // If player's symbol is found
                    coords[0] = i;
                    coords[1] = j;
                }
            }
        }

        int x = coords[0];
        int y = coords[1];

        // Calculate new player position based on totalMove
        int totalSpaces = 2 * board.length + 2 * (board[0].length - 2);

        //Calculate current position and new position
        int currentPosition = x + y;
        if (x == 0) {
            currentPosition = y;
        } else if (y == board[0].length - 1) {
            currentPosition = board[0].length - 1 + x;
        } else if(x == board.length - 1) {
            currentPosition = board.length - 1 + 2 * (board[0].length - 1) - y;
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
        } else if (newPosition < board[0].length + board.length - 1) {
            x = newPosition - board[0].length + 1;
            y = board[0].length - 1;
        } else if (newPosition < 2 * board[0].length + board.length - 2) {
            x = board.length - 1;
            y = 2 * board[0].length + board.length - 2 - newPosition - 1;
        } else {
            x = totalSpaces - newPosition;
            y = 0;
        }

        // Restore the board to its original state
        for (int i = 0; i < Board.originalBoard.length; i++) {
            for (int j = 0; j < Board.originalBoard[0].length; j++) {
                if (!(i == playerInstance.lastX && j == playerInstance.lastY) && !Board.originalBoard[i][j].equals(" P" + (searchIndex + 1) + " ")) {
                    board[i][j] = Board.originalBoard[i][j];
                }
            }
        }

        //Update Player Position
        board[x][y] = playerSymbol;

        playerInstance.lastX = x;
        playerInstance.lastY = y;

        playerInstance.x = x;
        playerInstance.y = y;

        return board;
    }
}
