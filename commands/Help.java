package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {
    private String topic;
    
    public Help(){
        commandType = CommandType.HELP;
        this.topic = topic;
    }

    public Help(String topic) {
        commandType = CommandType.HELP;
        this.topic = topic;
    }

    public String toString() {
        return "HELP " + topic;
    }

    public String execute(GameState gameState) {
        if (topic == null) {
            return "Welcome to the game! These are the commands. \n- MOVE \n - HELP \n - WYXZ";
        } else {
            return switch (topic.toLowerCase()) {
                case "use" -> "Use this command to use an item";
                case "look" -> "Use command to look at something closer";
                case "drop" -> "Drop something";
                case "get" -> "Get something";
                case "help" -> "gives thsi command";
                case "move" -> "MOVE Command: Use the 'move' command and specify a 'direction'";
                case "quit" -> "represents quit command, allows player to exit the game";
                case "status" -> "Returns status";
                default -> "No help available for the topic: " + topic;

            };
        }
    }
}