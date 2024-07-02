package Type;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class FancyRatTest {
    private CharacterType fancyRat;
    @Before
    public void setUp() throws Exception {
        fancyRat = new FancyRat();
    }


    @Test
    public void isInitialized() {
        String size = "medium";
        String type = "FancyRat";

        assertEquals(size, fancyRat.getSize());
        assertEquals(type, fancyRat.getType());
    }

}