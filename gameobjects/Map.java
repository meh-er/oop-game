package org.uob.a2.gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.nio.file.*;

import org.uob.a2.utils.*;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {
  private HashMap<String, Room> rooms = new HashMap<String, Room>();
  Room currentRoom;

    public Map() {
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void addRoom(Room room) {
        rooms.put(room.getId(), room);
    }

    public void setCurrentRoom(String roomId) {
        this.currentRoom = (rooms.get(roomId));
    }



    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms.values()) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}

