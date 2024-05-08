package com.cm6123.monopoly;

import com.cm6123.monopoly.app.PlayerProcessing;
import com.cm6123.monopoly.dice.Dice;
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
    private Properties property;
    private Dice dice;
    private Properties[][] board;
    private String[] playerNames;

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
        property = new Properties("TestProperty", PropertyType.Property, null, 200, 0);
        dice = new Dice(6);
        board = new Properties[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Properties testProperty = new Properties("TestProperty", PropertyType.Property, null, 0, 0);
                board[i][j] = testProperty;
            }
        }
        playerNames = new String[]{"TestPlayer"};
    }

    @Test
    public void testGetPlayerName() {
        String[] playerNames = {"TestPlayer", "Player2"};
        assertEquals("TestPlayer", player.getPlayerName());
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000, player.getBalance());
    }

    @Test
    public void testAddBalance() {
        player.addBalance("TestPlayer", 500);
        assertEquals(1500, player.getBalance());
    }

    @Test
    public void testGetPlayerAssests() {
        Player player = new Player("TestPlayer");
        Properties property = new Properties("TestProperty", PropertyType.Property, player, 0, 0);
        player.addPropertyToAssets(property);
        assertEquals("Your properties: \nTestProperty\n", player.getPlayerAssests());
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
        assertEquals(0, player.getNewX());
    }

    @Test
    public void testGetNewY() {
        Player player = new Player("TestPlayer");
        assertEquals(0, player.getNewY());
    }

    @Test
    public void testSetBalance() {
        Player player = new Player("TestPlayer");
        player.setBalance(2000);
        assertEquals(2000, player.getBalance());
    }

    @Test
    public void testAddPropertyToAssets() {
        Player player = new Player("TestPlayer");
        Properties property = new Properties("TestProperty", PropertyType.Property, player, 0, 0);
        player.addPropertyToAssets(property);
        assertEquals("Your properties: \nTestProperty\n", player.getPlayerAssests());
    }

    @Test
    public void testPrintPlayerPosition() {
        Player player = new Player("TestPlayer");
        Properties[][] board = new Properties[3][3];
        for (Properties[] row : board) {
            Properties empty = new Properties("Empty", PropertyType.Empty, null, 0, 0);
            Arrays.fill(row, empty);
        }

        Properties testProperty = new Properties("TestProperty", PropertyType.Property, null, 0, 0);
        board[1][1] = testProperty;

        // Capture the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the method with the test player and board
        Properties property = Player.printPlayerPosition(1, 1, board);

        // Check the method's return value and console output
        assertEquals(testProperty, property);
        assertEquals("You are currently at: TestProperty", outContent.toString().trim());
    }

    @Test
    public void testMovePlayer() {
        Player player = new Player("TestPlayer");
        Properties playerSymbol = new Properties("    P" + 1 + "     ", PropertyType.Player, null, 0, 0);
        Properties[][] board = new Properties[3][3];

        for (Properties[] row : board) {
            Properties empty = new Properties("Empty", PropertyType.Property, null, 0, 0);
            Arrays.fill(row, empty);
        }
        board[0][0] = playerSymbol;

        // Call the method with the test player and board
        Properties[][] updatedBoard = Player.movePlayer(board, 2, 0, "TestPlayer", player, playerSymbol);

        // Check the player's new position
        assertEquals(playerSymbol, updatedBoard[0][2]);

        // Check the player's internal coordinates
        assertEquals(0, player.getX());
        assertEquals(2, player.getY());
    }

    @Test
    public void testCheckForPropertyPurchase() {
        Player player = new Player("TestPlayer");
        Properties property = new Properties("TestProperty", PropertyType.Property, null, 200, 0);
        String input = "\n" + "\nyes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        player.checkForPropertyPurchase(property, scanner, dice.rollTwoDice());
        assertEquals("Your properties: \nTestProperty\n", player.getPlayerAssests());
    }

    @Test
    public void testPlayerTurn() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        player.playerTurn(scanner, playerNames, 0, board, dice);
        assertTrue(player.getBalance() >= 0);
    }
}
