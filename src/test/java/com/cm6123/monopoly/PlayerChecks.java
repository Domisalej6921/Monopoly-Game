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
    public void testPlayerCounterInputValid() {
        String testInput = "2";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        setUpStreams();
        int result = PlayerProcessing.playerCounterInput(scanner);
        tearDownStreams();
        if (result != 2) {
            System.out.println("Player Input Test Failed: Expected 2, Got " + result);
        } else {
            System.out.println("Player Input Test Passed.");
        }
    }

    @Test
    public void testPlayerNameInput() {

        // Set up mock input
        String[] input = {"Player1", "Player2", "Player3"};

        // Call the method to be tested
        Scanner scanner = new Scanner(String.join("\n", input));
        String[] playerNames = PlayerProcessing.playerNameInput(3, scanner);

        // Check if the output is as expected
        String expectedOutput = "Please name each of the players: (3 -- One after the other.): \n" + "Player Names: \n" + Arrays.toString(playerNames) + "\n";

        // Check if the returned value is as expected
        assertArrayEquals(input, playerNames);
    }

    @Test
    public void testGetPlayerName() {
        String[] playerNames = {"TestPlayer", "Player2"};
        assertEquals("TestPlayer", Player.getPlayerName(playerNames, 0));
        assertNull(Player.getPlayerName(playerNames, 2));
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000, Player.getBalance());
    }

    @Test
    public void testAddBalance() {
        Player.addBalance("TestPlayer", 500);
        assertEquals(1500, Player.getBalance());
    }
}
