package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
 public class Get extends Command {
//Room currentRoom = gameState.getMap().getCurrentRoom();
//Player player = gameState.getPlayer();

    private String item;

    public Get(String item) {
        commandType = CommandType.GET;
        this.item = item;
    }

    public String toString() {
        return "GET " + item;
    }

    public String execute(GameState gameState) {
        Room room = gameState.getMap().getCurrentRoom();
        Player player = gameState.getPlayer();
       
        for (Item item : room.getItems()) {
         if (this.item.equals(item.getName()) && !player.hasItem(this.item)) {
             player.addItem(item);
             room.removeItem(item);
             gameState.getPlayer().setScore();
             return "You pick up: " + this.item + "Your score is " + gameState.getPlayer().getScore();
         } 
            }
        for (Equipment equipment : room.getEquipments()) {
          if (this.item.equals(equipment.getName()) && !player.hasEquipment(this.item)) {
             player.addEquipment(equipment);
            room.removeEquipment(equipment);
            
            return "You pick up: " + this.item;
        }
     }
        if (player.hasItem(item) || player.hasEquipment(item)) {
             return "You already have " + this.item;
        } 
             return "No " + this.item + " to get.";
         }
    }

 

