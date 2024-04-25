package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BoardChecks {

    @Test
    public void testValidInput() {
        //Preparing input
        String input = "30";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        //Call the method
        int result = Board.boardInput(scanner);

        //Validate result
        assertEquals(30, result);
    }

    @Test
    public void testInvalidInputThenValidInput() {
        //Preparing input
        String input = "5\n60\n30";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        //Calling method
        int result = Board.boardInput(scanner);

        //Validating result
        assertEquals(30, result);
    }

    @Test
    public void testBoundaryInput() {
        //Preparing input
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        //Calling method
        int result = Board.boardInput(scanner);
        assertEquals(10, result);
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
