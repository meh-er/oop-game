package org.uob.a2.utils;

import java.io.*;
import java.util.Scanner;

import org.uob.a2.gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class  GameStateFileParser {
    GameState gameState;
    private Scanner scanner;
    private Room recent;
    private String startID;


    //get most recent room for adding equipment and items etc

    public GameStateFileParser(){
    }
    public static GameState parse(String filename) {
        GameStateFileParser parser = new GameStateFileParser();
        return parser.parseInner(filename);
    }
    private GameState parseInner(String filename){

        File file = new File(filename);
        
        try (Scanner scanner = new Scanner(file)){
            gameState = new GameState();
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                data = data.trim();
                if (data.contains(":")){
                    String[] dataSplit = data.split(":");                        
                     switch(dataSplit[0]){
                        case "map": makeMap(dataSplit[1]); break;
                        case "room": makeRoom(dataSplit[1]);break;
                        case "equipment": makeEquipment(dataSplit[1]);break;
                        case "container": makeContainer(dataSplit[1]);break;
                        case "item": makeItem(dataSplit[1]);break;
                        case "exit": makeExit(dataSplit[1]);break;
                        case "player": makePlayer(dataSplit[1]); break;
                    }
                }
            }
            gameState.getMap().setCurrentRoom(startID);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 

     return gameState;
    }
    
    public void makePlayer(String content){
        gameState.setPlayer(new Player(content));

    }
    public void makeMap(String content){
        
        Map map = new Map();
        gameState.setMap(map);
        startID = content;

    }

    public void makeRoom(String content){
        content = content.trim();
        String[] contentSplit = content.split(",");
        Room room = new Room(contentSplit[0], contentSplit[1], contentSplit[2], Boolean.parseBoolean(contentSplit[3]));
        gameState.getMap().addRoom(room);
        setRecentRoom(room);
    }

    public void makeEquipment(String content){
        content = content.trim();
        String[] contentSplit = content.split(",");
        getRecentRoom().addEquipment(new Equipment(contentSplit[0], contentSplit[1], contentSplit[2], Boolean.parseBoolean(contentSplit[3]), new UseInformation(false, contentSplit[4], contentSplit[5], contentSplit[6], contentSplit[7])));
    }


    public void makeContainer(String content){
        content = content.trim();
        String[] contentSplit = content.split(",");
        getRecentRoom().addFeature(new Feature(contentSplit[0], contentSplit[1], contentSplit[2], Boolean.parseBoolean(contentSplit[3])));
    }

    public void makeItem(String content){
        content = content.trim();
        String[] contentSplit = content.split(",");
        getRecentRoom().addItem(new Item(contentSplit[0], contentSplit[1], contentSplit[2], Boolean.parseBoolean(contentSplit[3])));

    }

    public void makeExit(String content){
        content = content.trim();
        String[] contentSplit = content.split(",");
        getRecentRoom().addExit(new Exit(contentSplit[0], contentSplit[1], contentSplit[2],contentSplit[3], Boolean.parseBoolean(contentSplit[4]))); 

    }

    public void setRecentRoom(Room room) {
        this.recent = room;
    }

    public Room getRecentRoom() {
        return recent;
    }

}
