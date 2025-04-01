package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

import java.util.ArrayList;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 * 
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {

    private String direction;
    private Room currentRoom;
    private String nextRoom;

    public Move(String direction) {
        commandType = CommandType.MOVE;
        this.direction = direction;
    }

    public String toString() {
        return "MOVE " + direction;

    }

    public String execute(GameState gameState) {
        currentRoom = gameState.getMap().getCurrentRoom();
        Map map = gameState.getMap();
        
         for (Exit exit: currentRoom.getExits()) {
             if (direction.equals(exit.getName()) && (!exit.getHidden())){
                map.setCurrentRoom(exit.getNextRoom());
                return "Moving towards " + direction + "\n ..................";
            } 
            }

        

        return "No exit found in that direction.";
    }
}
