package SpaceStation;

import Game.Cycle;
import Game.Part;

/**
 * The SpaceStation is the dungeon in this rpg.
 * It uses the singleton design pattern.
 * It has a top floor and many other floors used in cycles and parts.
 * It saves which level the player is currently on and how many total levels there are.
 */
public class SpaceStation {
    //"Dungeon"
    private int currentLevel;
    private int totalLevels;
    private Floor currentFloor;
    private static SpaceStation spaceStation;

    //should only ever be one spacestation use design pattern for this
    private SpaceStation() {
        this.currentLevel = 1;
        this.totalLevels= 1;
    }

    public static SpaceStation getSpaceStation(){
        if(spaceStation == null){
            spaceStation = new SpaceStation();
        }
        return spaceStation;
    }

    public void setFloor(Floor floor) {
        this.currentFloor = floor;
        this.currentLevel = floor.getLevel();
    }

    public Floor getFloor() {
        return this.currentFloor;
    }

    public int getLevel(){
        return this.currentLevel;
    }

    public void incrementTotalLevels() {
        this.totalLevels++;
    }
    public int getTotalLevels() {
        return this.totalLevels;
    }

    public void resetTotalLevels() {
        totalLevels = 1;
    }
}
