package com.cm6123.monopoly.game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    /**
     * Initialises player's name.
     */
    private static String[] playerName;

    /**
     * Initiates default balance value.
     */
    private int balance;

    /**
     * Initialises player x location on board;
     */
    private static int x;

    /**
     * Initialises player y location on board;
     */
    private static int y;

    /**
     * constructor for the player class.
     *
     * @param name
     */
    public Player(final String[] name) {
        this.playerName = name;
        this.balance = 1000;
        this.x = 0;
        this.y = 0;
    }

    public static String getPlayerName(String[] playerNames, int searchIndex) {
        if (searchIndex >= 0 && searchIndex < playerNames.length) {
            return playerNames[searchIndex];
        }
        // If the index is out of bounds, return null
        return null;
    }


    public static String[][] movePlayer(String[][] board, int totalMove) {
        int [] coords = new int[2];
        String playerSymbol = " P  ";
        String[][] oldBoard = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(playerSymbol)) { // If player's symbol is found
                    coords[0] = i;
                    coords[1] = j;
                }
            }
        }

        int x = coords[0];
        int y = coords[1];

        //Clears current player position
        board[x][y] = "Home";

        // Calculate new player position based on totalMove
        x = (x + totalMove + 2) % board.length;
        y = (y + totalMove + 2) % board[0].length;

        // Handle negative indices due to modulus
        if (x < 0) x += board.length;
        if (y < 0) y += board[0].length;

        // Search for the nearest non-empty position
        for (int distance = 1; distance < board.length; distance++) {
            boolean found = false;
            for (int dx = -distance; dx <= distance; dx++) {
                for (int dy = -distance; dy <= distance; dy++) {
                    //calculates new position
                    int newX = x + dx;
                    int newY = y + dy;

                    // Skip positions outside the board
                    if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length)
                        continue;

                    // Skip positions with "    "
                    if (!board[newX][newY].equals("    ")) {
                        //Replaces square to og state
                        board[x][y] = "Home";

                        // Update player position
                        board[newX][newY] = playerSymbol;
                        found = true;
                        break; // Exit loop once position is found
                    }
                }
                if (found) // Exit outer loop if position is found
                    break;
            }
            if (found) // Exit outer loop if position is found
                return board;
            }

            // Update player position
            board[x][y] = " P  ";
        return oldBoard;
    }
}
