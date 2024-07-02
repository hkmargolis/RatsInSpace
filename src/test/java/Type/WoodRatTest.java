package Type;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import static org.junit.Assert.*;

public class WoodRatTest {
    private CharacterType woodRat;
    @Before
    public void setUp() throws Exception {
        woodRat = new WoodRat();
    }


    @Test
    public void isInitialized() {
        String size = "small";
        String type = "WoodRat";

        assertEquals(size, woodRat.getSize());
        assertEquals(type, woodRat.getType());
    }

}