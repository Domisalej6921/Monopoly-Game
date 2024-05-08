package com.cm6123.monopoly;

import com.cm6123.monopoly.game.Player;
import com.cm6123.monopoly.game.PlayerClass;
import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Properties;
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
}
