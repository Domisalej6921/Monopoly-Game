package com.cm6123.monopoly.game;

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
     * Initialises player x location on board.
     */
    private static int x;

    /**
     * Initialises player y location on board.
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
     * used to move the player around the board String[][].
     * @param board
     * @param totalMove
     * @param searchIndex
     * @return old board.
     */
    public static String[][] movePlayer(final String[][] board, final int totalMove, final int searchIndex) {
        int [] coords = new int[2];
        String playerSymbol = " P ";
        String[][] oldBoard = board;

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

        //Clears current player position
        board[x][y] = "Home";

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

        //Update Player Position
        board[x][y] = playerSymbol;
        System.out.println("Player " + playerSymbol + " moved to " + x + ", " + y);

        return board;
    }
}
