package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 * 
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Use extends Command {
    private String equipmentName;
    private String target;
    private Player player;
    private Room room;

    public Use(String equipmentName, String target) {
        this.commandType = CommandType.USE;
        this.equipmentName = equipmentName;
        this.target = target;
    }

    public String toString() {

        return "USE " + equipmentName + " on " + target;
    }

    public String execute(GameState gameState) {
        room = gameState.getMap().getCurrentRoom();
        player = gameState.getPlayer();
        if(player.hasEquipment(equipmentName)){
            if (room.getFeatureByName(target)==null){
                 return "Invalid use target";
                }
            if (player.getEquipment(equipmentName).getUseInformation().getTarget().equals(room.getFeatureByName(target).getId())){
                if (player.getEquipment(equipmentName).getUseInformation().isUsed()==false){
                    player.getEquipment(equipmentName).getUseInformation().setUsed(true);
                    room.getItem(player.getEquipment(equipmentName).getUseInformation().getResult()).setHidden(false);
                    return player.getEquipment(equipmentName).getUseInformation().getMessage();
                }
                else{return "You have already used " +equipmentName;}
            }
        }
        return "You do not have " + equipmentName;
    }
}