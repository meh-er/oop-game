package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents the player in the game, including their name, inventory, and equipment.
 * 
 * <p>
 * The player can carry items and equipment, interact with the game world, and perform
 * actions using their inventory or equipment.
 * </p>
 */

public class Player {
    private String name;
   // public Player player;
    private ArrayList<Equipment> equipments;
    private ArrayList<Item> inventory;

   public Player(String name) {
        this.equipments = new ArrayList<Equipment>();
        this.inventory = new ArrayList<Item>();
        this.name = name;
   }

   public Player() {
       this.equipments = new ArrayList<>();
       this. inventory = new ArrayList<>();

   }
   public String getName() {
       return name;
   }

   public ArrayList<Item> getInventory(){
       return inventory;
   }

   public boolean hasItem(String itemName){
       for (Item item : inventory) {
           if (item.getName().equalsIgnoreCase(itemName)) {
               return true;
           }
       }
       return false;
   }



   public Item getItem(String itemName){
      for (Item item : inventory) {
           if (item.getName().equals(itemName)) {
               return item;
           } 
       }
       return null;
   }

   public void addItem(Item item){
       this.inventory.add(item);
   }

   public ArrayList<Equipment> getEquipment(){
        return equipments;
   }

 public boolean hasEquipment(String equipmentName) {
       for (Equipment equipment : equipments) {
           if (equipment.getName().equalsIgnoreCase(equipmentName)) {
               return true;
           }
       }
       return false;
   }


   public Equipment getEquipment(String equipmentName){
       for (Equipment equipment : equipments) {
           if (equipment.getName().equals(equipmentName)) {
               return equipment;
           }
       }
       return null;
   }

   public void addEquipment(Equipment equipment){
       this.equipments.add(equipment);
   }

    public Equipment getEquipmentByName(String name) {
        for (Equipment e : equipments) {
            if(e.getName().equalsIgnoreCase(name)){
                return e;
            }
        }
        return null;
    }

    public Item getItemByName(String name) {
        for (Item item : inventory) {
            if(item.getName().equalsIgnoreCase(name)){
                return item;
            }
        }
        return null;
    }
    
    public void removeItem(Item item) {
    inventory.remove(item);
    }

    public void removeEquipment(Equipment equipment) {
    equipments.remove(equipment);
    }

    public void setScore(){
       setScore();
    }

    public int getScore(){
       return getScore();
    }

    /**
     * Returns a string representation of the player's current state, including their name,
     * inventory, and equipment descriptions.
     *
     * @return a string describing the player, their inventory, and equipment
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Player Name: " + this.name + "\nInventory:\n");
        for (Item i : this.inventory) {
            out.append("- ").append(i.getDescription()).append("\n");
        }
        out.append("Equipment:\n");
        for (Equipment e : this.equipments) {
            out.append("- ").append(e.getDescription()).append("\n");
        }
        return out.toString();
    }
}
