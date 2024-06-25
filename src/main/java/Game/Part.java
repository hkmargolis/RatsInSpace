package Game;
import SpaceStation.Floor;

import java.util.ArrayList;

public class Part {

    //3-5 floors
    private ArrayList<Floor> floors;

    public Part() {
        floors = generateFloors();
    }

    public ArrayList<Floor> generateFloors() {
        Floor floor1 = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
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

}
