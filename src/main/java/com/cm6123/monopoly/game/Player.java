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


}
