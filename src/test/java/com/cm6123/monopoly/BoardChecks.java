package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Board;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BoardChecks {

    @Test
    public void testBoardInput() {
        String input = "25";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);

        Board aBoard = new Board();

        int userInput = Board.boardInput(scanner);

        assertTrue(userInput >= 10 && userInput <= 50);

        scanner.close();
    }

    @Test
    public void testCreateSpace() {
        String expectedSpace = """
                +----------+
                |Space     |
                |----------|
                |          |
                |          |
                +----------+
                """;

        assertEquals(expectedSpace, Board.createSpace());
    }
}
