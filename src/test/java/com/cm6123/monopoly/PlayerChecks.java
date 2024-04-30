package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class PlayerChecks {
    private final InputStream originalSystemIn = System.in;

    public void setUpStreams() {
        // Redirect System.in to provide input for playerInput method
        String input = "2"; // Provide input for testing
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public void tearDownStreams() {
        // Restore original System.in
        System.setIn(originalSystemIn);
    }

    @Test
    public void testPlayerInputValid() {
        String testInput = "2";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        setUpStreams();
        int result = Player.playerInput(scanner);
        tearDownStreams();
        if (result != 2) {
            System.out.println("Player Input Test Failed: Expected 2, Got " + result);
        } else {
            System.out.println("Player Input Test Passed.");
        }
    }
}
