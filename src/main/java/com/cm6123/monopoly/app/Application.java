package com.cm6123.monopoly.app;

import com.cm6123.monopoly.game.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public final class Application {
    /**
     * Create a logger for the class.
     */
    private static Logger logger = LoggerFactory.getLogger(Application.class);


    private Application() {
    }

    /**
     * main entry point.  If args provided, result is displayed and program exists. Otherwise, user is prompted for
     * input.
     *
     * @param args command line args.
     */
    public static void main(final String[] args) {


        logger.info("Application Started with args:{}", String.join(",", args));

        System.out.println("\nHello. Welcome to Monopoly. \n");

        Scanner scanner = new Scanner(System.in);
        BoardProcessing boardProcessing = new BoardProcessing();
        Properties[][] board = boardProcessing.boardExecution(scanner);


        PlayerProcessing playerProcessing = new PlayerProcessing();
        playerProcessing.playerExecution(scanner, board);

        logger.info("Application closing");
    }
}
