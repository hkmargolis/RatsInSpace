package Game;
import SpaceStation.Floor;
import SpaceStation.SpaceStation;

import java.util.ArrayList;

public class Part {

    //3-5 floors
    private ArrayList<Floor> floors;

    public Part(SpaceStation spaceStation) {
        floors = generateFloors(spaceStation);
    }

    private ArrayList<Floor> generateFloors(SpaceStation spaceStation) {
        //1 part has 3 floors
        Floor floor1 = new Floor(spaceStation);
        Floor floor2 = new Floor(spaceStation);
        Floor floor3 = new Floor(spaceStation);
        return new ArrayList<>(){{add(floor1); add(floor2); add(floor3);}};
    }

    public Floor getFloor() {
        if(!floors.isEmpty()){
            return floors.get(0);
        }
        else{
            System.out.println("No more floors in this part to get.");
            return null;
        }
    }

    public void removeFloor() {
        if(!floors.isEmpty()){
            floors.remove(0);
        }
        else{
            System.out.println("No more floors in this part to remove.");
        }
    }

    public boolean isOver() {
        return floors.isEmpty();
    }
}
