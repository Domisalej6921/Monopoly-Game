package com.cm6123.monopoly;

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


public class PlayerClassTests {

    private Player player;
    private Properties property;
    private Dice dice;
    private String[][] board;
    private String[] playerNames;

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer");
        property = new Properties("TestProperty", PropertyType.Property, null, 200, 0);
        dice = new Dice(6);
        board = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "TestProperty";
            }
        }
        playerNames = new String[]{"TestPlayer"};
    }

    @Test
    public void testCheckForPropertyPurchase() {
        Player player = new Player("TestPlayer");
        Properties property = new Properties("TestProperty", PropertyType.Property, null, 200, 0);
        String input = "\n" + "\nyes\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        PlayerClass.checkForPropertyPurchase(player, property, scanner, dice.rollTwoDice());
        assertEquals("You do not have any Properties.", Player.getPlayerAssests(player));
    }

    @Test
    public void testPlayerTurn() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        PlayerClass.playerTurn(scanner, playerNames, 0, board, player, dice);
        assertTrue(player.getBalance(player) >= 0);
    }
}
