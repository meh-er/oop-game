package org.uob.a2.parser;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * The {@code Tokeniser} class is responsible for converting a string input into a list of tokens
 * that can be parsed into commands by the game.
 * 
 * <p>
 * The tokeniser identifies keywords, variables, and special symbols, assigning each a {@code TokenType}.
 * </p>
 */
public class Tokeniser {
    //Tokeniser tokeniser = new Tokeniser();
    private ArrayList<Token> tokens;

    public Tokeniser(){
        this.tokens = new ArrayList<>();
    }

    public ArrayList<Token> getTokens(){

        return tokens;
    }

    public String sanitise(String s){
        s = s.toLowerCase().trim();
        return s;
    }

    public void clear(){
        tokens.clear();
    }

    public void tokenise(String s){
        s = sanitise(s);
        String[] splitArray = s.split("\\s+");
        for (int i = 0; i < splitArray.length; i++) {
            String token = splitArray[i];
            switch (token) {
                case "drop" -> tokens.add(new Token(TokenType.DROP));
                case "get" -> tokens.add(new Token(TokenType.GET));
                case "help" -> tokens.add(new Token(TokenType.HELP));
                case "look" -> tokens.add(new Token(TokenType.LOOK));
                case "move" -> tokens.add(new Token(TokenType.MOVE));
                case "quit" -> tokens.add(new Token(TokenType.QUIT));
                case "status" -> tokens.add(new Token(TokenType.STATUS));
                case "use" -> tokens.add(new Token(TokenType.USE));
                case "eol" -> tokens.add(new Token(TokenType.EOL));
                //case "combine" -> tokens.add(new Token(TokenType.COMBINE));
                case "on", "and" -> tokens.add(new Token(TokenType.PREPOSITION, token));
                default -> tokens.add(new Token(TokenType.VAR, token));
            }
        }
                    tokens.add(new Token(TokenType.EOL));

    }
   
}
