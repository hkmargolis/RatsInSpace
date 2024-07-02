package Game;

import SpaceStation.SpaceStation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CycleTest {
    private Cycle cycle;
    private SpaceStation spaceStation;
    @Before
    public void setUp() throws Exception {
        spaceStation = SpaceStation.getSpaceStation();
        cycle = new Cycle(spaceStation);
    }

    @Ignore
    public void getPart() {

    }

    @Ignore
    public void removePart() {
    }

    @Test
    public void isOver() {
        cycle.removePart();
        cycle.removePart();
        cycle.removePart();
        cycle.removePart();
        boolean over = cycle.isOver();
        assertEquals(over, true);
    }
}