package org.uob.a2;
import java.util.ArrayList;
import java.util.Scanner;
import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;
import org.uob.a2.parser.*;
import org.uob.a2.utils.*;

import java.io.*;

/**
 * Main class for the game application. Handles game setup, input parsing, and game execution.
 * 
 * <p>
 * This class initializes the game state, reads user input, processes commands, and maintains the game loop.
 * </p>
 */
public class Game {
    private static GameState gameState;
    private static Scanner scanner;
    private static Parser parser;
    private static Tokeniser tokeniser;
    private static String input;
    private static ArrayList<Token> tokens;
    private static Command command;
    private static GameStateFileParser gameStateFileParser;


        public Game() {

        }
        public static void main(String[] args) {
        gameState = new GameState();
        scanner = new Scanner(System.in);
        parser = new Parser();
        tokeniser = new Tokeniser();
        File tempFile = new File("data/game.txt");
        GameState gameState = GameStateFileParser.parse(tempFile.getAbsolutePath());

        input = "start";
        while(!input.equals("quit")){
            System.out.println("You are at " + gameState.getMap().getCurrentRoom().getName() + ".");
            System.out.println("Type in a command: ");
            input = scanner.nextLine();
            tokeniser.clear();
            tokeniser.tokenise(input);
           


            try {
                command = parser.parse(tokeniser.getTokens());
                System.out.println(command.execute(gameState));
            } catch (CommandErrorException e) {
                throw new RuntimeException(e);
            }
        }
        }
    
        public static void setup(){
            
        }

        public static void start() {
        }

        public static void turn (){
            }


}

