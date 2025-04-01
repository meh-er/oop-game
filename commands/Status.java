package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {
    private String topic;

    public Status(String topic) {
        this.commandType = CommandType.STATUS;
        this.topic = topic;
    }

    public String toString() {
        return "STATUS " + topic;
    }
    public String execute(GameState gameState) {
        Player player = gameState.getPlayer();
        String s = "Inventory: ";
        switch(topic){
            case "inventory":
                for (Item item : player.getInventory()) {
                   s +=  item.getName() + " " ;
                }
                for (Equipment equipment : player.getEquipment()) {
                   s += equipment.getName() + " ";
                } return s;
            case "player":
                    return "Player" + player.getName();
            case "map":
                return "Map: " + gameState.getMap().toString();
            case "score": 
                return "Score ";
            default:
         for (Item item : player.getInventory()) {
            if (topic.equals(item.getName())) {
                   return item.getDescription();
            }
        }
            for (Equipment equipment : player.getEquipment()) {
                if (topic.equals(equipment.getName())) {
                    return equipment.getDescription();
                } 
            }
        }
       
            return "";
            }

    }


