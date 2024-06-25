package SpaceStation;

public class SpaceStation {
    //"Dungeon"
    public int currentLevel;
    public int totalLevels;
    Floor floor;
    TopFloor topFloor;

    //should only ever be one spacestation use design pattern for this
    public SpaceStation() {
        this.currentLevel = 1;
        topFloor = new TopFloor();
        floor = topFloor;
        totalLevels = 1;

    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }
}
