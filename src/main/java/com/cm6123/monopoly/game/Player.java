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

    public static String getPlayerNames(String[] playerNames) {

        String singlePlayerName = null;

        // Iterate over each string in the string array
        for (String singleName : playerNames) {
            singlePlayerName = singleName;
        }
        return singlePlayerName;
    }



//    public static int[][] getPos() {
//        int [][] coords = new int[][];
//
//        return coords
//    }
}