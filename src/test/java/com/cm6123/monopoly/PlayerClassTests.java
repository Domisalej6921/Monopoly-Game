package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.PlayerClass;
import com.cm6123.monopoly.game.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerClassTests {

    private final InputStream originalSystemIn = System.in;
    private Player player;

    @Test
    public void testPlayerTurn() {
        // Set up mock input
        String[] playerNames = {"Player1", "Player2", "Player3"};
        String[][] board = Board.boardCreation(20);
        Player currentPlayer = new Player("TestPlayer");
        int searchIndex = 0;
        ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        PlayerClass.playerTurn(scanner, playerNames, searchIndex, board, currentPlayer);
    }
}
