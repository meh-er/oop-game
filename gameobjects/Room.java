package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 * 
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {
    private ArrayList<Feature> features;
    private ArrayList<Exit> exits;
    private ArrayList<Equipment> equipments;
    private ArrayList<Item> items;
    private ArrayList<GameObject> gameObjects;


    public Room() {
        this.features = new ArrayList<Feature>();
        this.exits = new ArrayList<Exit>();
        this.equipments = new ArrayList<Equipment>();
        this.items =  new ArrayList<Item>();
        //this.gameObjects = new ArrayList<GameObject>();
    }

    public Room(String id, String name, String description, boolean hidden) {
        super(id, name, description, hidden);
        this.features = new ArrayList<Feature>();
        this.exits = new ArrayList<Exit>();
        this.equipments = new ArrayList<Equipment>();
        this.items =  new ArrayList<Item>();
        this.gameObjects = new ArrayList<GameObject>();
    }

    
    
    public ArrayList<Exit> getExits() {
        return exits;
    }

    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getItem(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            } else {
                return null;
            }
        }
        return null;
    }


    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            } else {
                return null;
            }
        }
        return null;
    }


    public Feature getFeatureByName(String name) {
        for (Feature feature : features) {
            if (feature.getName().equals(name)) {
                return feature;
            } else {
                return null;
            }
        }
        return null;
    }

    public Exit getExitsByName(String name) {
        for (Exit exit : exits) {
            if (exit.getName().equals(name)) {
                return exit;
            } else {
                return null;
            }
        }
        return null;
    }


    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public Equipment getEquipmentByName(String name) {
        for (Equipment equipment : equipments) {
            if (equipment.getName().equals(name)) {
                return equipment;
            } else {
                return null;
            }
        }
        return null;
    }


    public Equipment getEquipment(String id) {
        for (Equipment equipment : equipments) {
            if (equipment.getId().equals(id)) {
                return equipment;
            } else {
                return null;
            }
        }
        return null;
    }

    public Exit getExit(String id) {
        for (Exit exit : exits) {
            if (exit.getId().equals(id)) {
                return exit;
                
            } else {
                return null;
            }
        }
        return null;
    }

    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    public Feature getFeature(String id) {
        for (Feature feature : features) {
            if (feature.getId().equals(id)) {
                return feature;
            } else {
                return null;
            }
        }
        return null;
    }



    public void addItem(Item item) {
       this.items.add(item);
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<GameObject> getAll() {
        return gameObjects;
    }

    public void addFeature(Feature feature) {
        this.features.add(feature);
    }


    public boolean hasItem(String itemName) {
      for (Item item : items) {
        if (item.getName().equals(itemName)) {
            return true;
        }
    }
    return false;
}
    
    public boolean hasEquipment(String name) {
      for (Equipment equipment : equipments) {
        if (equipment.getName().equals(name)) {
            return true;
        }
    }
    return false;
}
    
    public boolean hasFeature(String name) { return features.contains(name); }

    public void removeItem(Item item) {
    items.remove(item);
}

    public void removeEquipment(Equipment equipment) {
    equipments.remove(equipment);
}


    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipments) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
