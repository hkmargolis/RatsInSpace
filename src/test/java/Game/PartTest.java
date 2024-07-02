package Game;

import SpaceStation.SpaceStation;
import SpaceStation.Floor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartTest {
    private Part part;
    private SpaceStation spaceStation;

    @Before
    public void setup(){
        spaceStation = SpaceStation.getSpaceStation();
        spaceStation.resetTotalLevels();
        part = new Part(spaceStation); //creates 3 floors (levels 2,3, 4)
        //top floor is level1
    }
    @Test
    public void getFloor() {
        Floor floor = part.getFloor();
        int level = floor.getLevel();
        assertEquals(level,2);
    }

    @Test
    public void removeFloor() {
        part.removeFloor(); //removes floor 2 (first floor in part array)
        Floor floor = part.getFloor();
        int level = floor.getLevel();
        assertEquals(level,3);
    }

    @Test
    public void isOver() {
        part.removeFloor(); //removes floor 2 (first floor in part array)
        part.removeFloor(); //removes floor 3 (2nd floor in part array)
        part.removeFloor();//removes floor 4 (3rd floor in part array, now array should be empty)
        //part.removeFloor();
        boolean emptyPart = part.isOver();
        assertEquals(emptyPart, true);
    }
}