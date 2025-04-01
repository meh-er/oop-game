package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

import java.util.ArrayList;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 * 
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {
    private String target;
    private Room room;

    public Look(String target) {
        this.target = target;
    }

    public String toString() {
        return "LOOK " + target;
    }

    public String execute(GameState gameState) {
        Room room = gameState.getMap().getCurrentRoom();
         for (Item item : room.getItems()) {
           if (target.equals(item.getName()) && !item.getHidden()) {
                return item.getDescription();
            }
        }
        for (Equipment equipment : room.getEquipments()) {
                if (target.equals(equipment.getName()) && !equipment.getHidden()) {
            return equipment.getDescription();
            }  
                }
        for (Feature feature : room.getFeatures()) {
            if (target.equals(feature.getName()) && !feature.getHidden()) {
            return feature.getDescription();
            }  }
           
          if (target.equals("room")  || target.equals("exits") || target.equals("features")) {
        String s = " ";

            switch (target) {
                case "room":
                    for (Item item : room.getItems()) {
                        if (!item.getHidden()){
                       s +=  item.getDescription();
                        }
                }
                    for (Equipment equipment : room.getEquipments()) {
                        s += equipment.getDescription();
                    }
                    return room.getDescription() + " contains " + s;
                case "exits": 
                    for (Exit exit : room.getExits()) {
                        s += exit.getDescription();}
                        return "The available exits are: " + s;

                case "features": 
                      for (Feature feature : room.getFeatures()) {
                         s += feature.getDescription();}

                          return "You also see: " + s;
                      
                default: throw new IllegalStateException("Unexpected value: " + target);
            }
        } else {
            return "Nothing of importance to see here!";
        }

    }
}


        

