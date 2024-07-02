package SpaceStation;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpaceStationTest {
    private SpaceStation spaceStation;
    @Before
    public void setUp() throws Exception {
        spaceStation = SpaceStation.getSpaceStation();
    }
    @Test
    public void getSpaceStation() {
        assertEquals(spaceStation, SpaceStation.getSpaceStation());
    }

    @Test
    public void setFloor() {
        Floor floor = new Floor(spaceStation);
        //add floor 2
        spaceStation.setFloor(floor);
        assertEquals(spaceStation.getFloor(), floor);

    }

    @Test
    public void getFloor() {
        Floor floor = new Floor(spaceStation);
        //add floor 3
        spaceStation.setFloor(floor);
        assertEquals(spaceStation.getFloor(), floor);
    }

    @Test
    public void getLevel() {
        //total floors expected 3
        assertEquals(spaceStation.getLevel(), 3);
    }

    @Test
    public void incrementTotalLevels() {
        spaceStation.resetTotalLevels();
        spaceStation.incrementTotalLevels();
        assertEquals(spaceStation.getTotalLevels(),2);
    }

    @Test
    public void getTotalLevels() {
        spaceStation.resetTotalLevels();
        assertEquals(spaceStation.getTotalLevels(),1);
    }

    @Test
    public void resetTotalLevels() {
        spaceStation.resetTotalLevels();
        assertEquals(spaceStation.getTotalLevels(), 1);
    }
}