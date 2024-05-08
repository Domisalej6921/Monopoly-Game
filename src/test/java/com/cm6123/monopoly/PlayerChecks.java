package com.cm6123.monopoly;

import com.cm6123.monopoly.app.PlayerProcessing;
import com.cm6123.monopoly.game.*;
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

    @Test
    public void testGetPlayerAssests() {
        Player player = new Player("TestPlayer");
        Properties property = new Properties("TestProperty", PropertyType.Property, player, 0, 0);
        player.addPropertyToAssets(property);
        assertEquals("Your properties: \nTestProperty\n", Player.getPlayerAssests(player));
    }

    @Test
    public void testGetLastX() {
        Player player = new Player("TestPlayer");
        assertEquals(0, player.getLastX());
    }

    @Test
    public void testGetLastY() {
        Player player = new Player("TestPlayer");
        assertEquals(0, player.getLastY());
    }

    @Test
    public void testGetX() {
        Player player = new Player("TestPlayer");
        assertEquals(0, player.getX());
    }

    @Test
    public void testGetY() {
        Player player = new Player("TestPlayer");
        assertEquals(0, player.getY());
    }

    @Test
    public void testGetNewX() {
        Player player = new Player("TestPlayer");
        assertEquals(0, player.getNewX(player));
    }

    @Test
    public void testGetNewY() {
        Player player = new Player("TestPlayer");
        assertEquals(0, player.getNewY(player));
    }

    @Test
    public void testSetBalance() {
        Player player = new Player("TestPlayer");
        player.setBalance(2000);
        assertEquals(2000, Player.getBalance(player));
    }

    @Test
    public void testAddPropertyToAssets() {
        Player player = new Player("TestPlayer");
        Properties property = new Properties("TestProperty", PropertyType.Property, player, 0, 0);
        player.addPropertyToAssets(property);
        assertEquals("Your properties: \nTestProperty\n", Player.getPlayerAssests(player));
    }

    @Test
    public void testPrintPlayerPosition() {
        Player player = new Player("TestPlayer");
        String[][] board = new String[3][3];
        for (String[] row : board) {
            Arrays.fill(row, "Empty");
        }
        board[1][1] = "Property";

        // Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method with the test player and board
        String property = Player.printPlayerPosition(1, 1, board);

        // Check the method's return value and console output
        assertEquals("Property", property);
        assertEquals("You are currently at: Property", outContent.toString().trim());
    }

    @Test
    public void testMovePlayer() {
        Player player = new Player("TestPlayer");
        String[][] board = new String[3][3];
        for (String[] row : board) {
            Arrays.fill(row, "Empty");
        }
        board[0][0] = " P ";

        // Call the method with the test player and board
        String[][] updatedBoard = Player.movePlayer(board, 2, 0, "TestPlayer", player);

        // Check the player's new position
        assertEquals("     P1    ", updatedBoard[0][2]);
        assertEquals(" P ", updatedBoard[0][0]);

        // Check the player's internal coordinates
        assertEquals(0, player.getX());
        assertEquals(2, player.getY());
    }
}
