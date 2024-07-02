package Type;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import static org.junit.Assert.*;

public class PouchedRatTest {

        private CharacterType pouchedRat;
        @Before
        public void setUp() throws Exception {
            pouchedRat = new PouchedRat();
        }


        @Test
        public void isInitialized() {
            String size = "large";
            String type = "PouchedRat";

            assertEquals(size, pouchedRat.getSize());
            assertEquals(type, pouchedRat.getType());
        }

    }
