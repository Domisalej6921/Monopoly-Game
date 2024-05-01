package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Player;

import java.util.Scanner;

public class PlayerProcessing {

    /**
     * Handles the processing of player data.
     *
     * @param scanner allows user input.
     */
    private void playerProcessing(final Scanner scanner) {

        int playerCount = Player.playerCounterInput(scanner);
        String playerNames = Player.playerNameInput(playerCount, scanner);
    }

    /**
     * Executes the processing of user data.
     *
     * @param scanner allows user to input data.
     */
    public static final void playerExecution(final Scanner scanner) {
        PlayerProcessing exe = new PlayerProcessing();
        exe.playerProcessing(scanner);
    }
}
