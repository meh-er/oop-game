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

public class Combine extends Command {

    private String item1;
    private String item2;
    private Room room;
    private ArrayList<Equipment> equipment;
    private String equipment;

    public Combine(String item1, String item2) {
        this.commandType = CommandType.COMBINE;
        this.item1 = item1;
        this.item2 = item2;
        this.equipment = new ArrayList<>();

    }

    public String toString() {
        return "COMBINE " + item1 + " and " + item2;

    }

    public String execute(GameState gameState) {
        room = gameState.getMap().getCurrentRoom();
       equipment = room.getEquipments();
        Player player = gameState.getPlayer();
        Map map = gameState.getMap();
        
         for (Item item : player.getInventory()){
             if(this.item1.equals(item.getName()) && this.item2.equals(item.getName())){
                 player.removeItem(item);
                 if (item1.equals("flintstone") || item2.equals("flintstone")) {
                     player.addEquipment(room.getEquipment(String.valueOf(equipment)));
                     return "You have created " + room.getEquipment(String.valueOf(equipment)).getName() + "using " + item1 + " and " + item2;
                 }
             }
         }

        return "You are unable to combine these two items here!";
    }
}

 
