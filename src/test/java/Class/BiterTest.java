package Class;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BiterTest {
    private CharacterClass biter;
    @Before
    public void setUp() throws Exception {
        biter = new Biter();
    }


    @Test
    public void isInitialized() {
        String type = "Biter";
        ArrayList<String> skills = new ArrayList<String>(){{add("Scratch"); add("Bite"); add("Tail Whip"); add("Dodge");}};


        assertEquals(type, biter.getType());
        assertEquals(skills, biter.getSkills());
    }

}