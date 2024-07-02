package Class;

import Type.CharacterType;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ThiefTest {
    private CharacterClass thief;
    @Before
    public void setUp() throws Exception {
        thief = new Thief();
    }


    @Test
    public void isInitialized() {
        String type = "Thief";
        ArrayList<String> skills = new ArrayList<String>(){{add("Stealth"); add("Fast Hands"); add("Open Locks"); add("Set Traps");}};


        assertEquals(type, thief.getType());
        assertEquals(skills, thief.getSkills());
    }
}