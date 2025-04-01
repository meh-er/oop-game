package org.uob.a2.commands;
import java.util.ArrayList;
import org.uob.a2.gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 * 
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command {
    private String item;

    public Drop(String item) {
        this.item = item;
    }

   public String toString() {
        return "DROP " + item;
   }

   public String execute(GameState gameState) {
        Room room = gameState.getMap().getCurrentRoom();
        Player player = gameState.getPlayer();
        Map map = gameState.getMap();
       
    for (Item item : player.getInventory()) {
       if (this.item.equals(item.getName())){
           room.addItem(item);
           player.removeItem(item);
           return "You drop: " + this.item;
       }
        
    }
    for (Equipment equipment : player.getEquipment()) {
       if (this.item.equals(equipment.getName())){
           room.addEquipment(equipment);
           player.removeEquipment(equipment);
           return "You drop: " + this.item;
        }
    }
           return "You cannot drop " + item;
       }
    
   }
