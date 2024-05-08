package com.cm6123.monopoly;

import com.cm6123.monopoly.app.PlayerProcessing;
import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.PlayerClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerChecks {
    private final InputStream originalSystemIn = System.in;
    private Player player;

    public void setUpStreams() {
        // Redirect System.in to provide input for playerInput method
        String input = "2"; // Provide input for testing
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public void tearDownStreams() {
        // Restore original System.in
        System.setIn(originalSystemIn);
    }

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer");
    }

    @Test
    public void testGetPlayerName() {
        String[] playerNames = {"TestPlayer", "Player2"};
        assertEquals("TestPlayer", Player.getPlayerName(playerNames, 0));
        assertNull(Player.getPlayerName(playerNames, 2));
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000, Player.getBalance(player));
    }

    @Test
    public void testAddBalance() {
        Player.addBalance("TestPlayer", 500, player);
        assertEquals(1500, Player.getBalance(player));
    }
}
