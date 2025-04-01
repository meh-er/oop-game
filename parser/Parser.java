package org.uob.a2.parser;

import java.util.ArrayList;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;

/**
 * The {@code Parser} class processes a list of tokens and converts them into {@code Command} objects
 * that can be executed by the game.
 *
 * <p>
 * The parser identifies the type of command from the tokens and creates the appropriate command object.
 * If the command is invalid or incomplete, a {@code CommandErrorException} is thrown.
 * </p>
 */
public class Parser {


    public Parser() {


    }

    public Command parse(ArrayList<Token> tokens) throws CommandErrorException {
        return switch (tokens.get(0).getTokenType()) {
            case DROP -> parseDrop(tokens);
            case GET -> parseGet(tokens);
            case USE -> parseUse(tokens);
            case HELP -> parseHelp(tokens);
            case LOOK -> parseLook(tokens);
            case MOVE -> parseMove(tokens);
            case QUIT -> parseQuit(tokens);
           // case COMBINE -> parseCombine(tokens);
            case STATUS -> parseStatus(tokens);
            case PREPOSITION, VAR, ERROR -> throw new CommandErrorException("You can't start with this");
            case EOL -> throw new CommandErrorException("Error");

        };
    }


    public Command parseUse(ArrayList<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 4) {
            throw new CommandErrorException("Not enough arguments");
        }
        if ((tokens.get(1).getTokenType() != TokenType.VAR || (tokens.get(3).getTokenType()) != TokenType.VAR)) {
            throw new CommandErrorException("Error for this command");
        }
        if (tokens.get(2).getTokenType() != TokenType.PREPOSITION || (!tokens.get(2).getValue().equals("on"))) {
            throw new CommandErrorException("Error for this command");
        }
        return new Use(tokens.get(1).getValue(), tokens.get(3).getValue());
    }

     /*public Command parseCombine(ArrayList<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 4) {
            throw new CommandErrorException("Not enough arguments");
        }
        if ((tokens.get(1).getTokenType() != TokenType.VAR || (tokens.get(3).getTokenType()) != TokenType.VAR)) {
            throw new CommandErrorException("Error for this command");
        }
        if (tokens.get(2).getTokenType() != TokenType.PREPOSITION || (!tokens.get(2).getValue().equals("and"))) {
            throw new CommandErrorException("Error for this command");
        }
         return new Combine(tokens.get(1).getValue(), tokens.get(3).getValue());
    }

*/
    public Command parseGet(ArrayList<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 2) {
            throw new CommandErrorException("Not enough arguments");
        }
        if (tokens.get(1).getTokenType() != TokenType.VAR) {
            throw new CommandErrorException("Error for this command");
        }
        return new Get(tokens.get(1).getValue());

    }

    public Command parseDrop(ArrayList<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 2) {
            throw new CommandErrorException("Not enough arguments");
        }
        if (tokens.get(1).getTokenType() != TokenType.VAR) {
            throw new CommandErrorException("Error for this command");
        }
        return new Drop(tokens.get(1).getValue());

    }

    public Command parseLook(ArrayList<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 2) {
            throw new CommandErrorException("Not enough arguments");
        }
        if (tokens.get(1).getTokenType() != TokenType.VAR) {
            throw new CommandErrorException("Error for this command");
        }
        return new Look(tokens.get(1).getValue());

    }

    public Command parseMove(ArrayList<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 2) {
            throw new CommandErrorException("Not enough arguments");
        }
        if (tokens.get(1).getTokenType() != TokenType.VAR) {
            throw new CommandErrorException("Error for this command");
        }
        return new Move(tokens.get(1).getValue());

    }

    public Command parseQuit(ArrayList<Token> tokens) throws CommandErrorException {
        return new Quit();
    }

    public Command parseStatus(ArrayList<Token> tokens) throws CommandErrorException {
        if (tokens.size() < 2) {
            throw new CommandErrorException("Not enough arguments");
        }
        if (tokens.get(1).getTokenType() != TokenType.VAR) {
            throw new CommandErrorException("Error for this command");
        }
        return new Status(tokens.get(1).getValue());

    }

    public Command parseHelp(ArrayList<Token> tokens) throws CommandErrorException {
      if (tokens.size() < 2 || tokens.get(1).getTokenType() == TokenType.EOL) {
            return new Help();
        }
        if (tokens.get(1).getTokenType() == TokenType.VAR) {
            return new Help(tokens.get(1).getValue());
        }
        throw new CommandErrorException("Error for this command");


    }


}
 

