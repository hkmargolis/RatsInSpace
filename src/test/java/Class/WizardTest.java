package Class;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WizardTest {
    private CharacterClass wizard;
    @Before
    public void setUp() throws Exception {
        wizard = new Wizard();
    }


    @Test
    public void isInitialized() {
        String type = "Wizard";
        ArrayList<String> skills = new ArrayList<String>(){{add("Investigation"); add("History"); add("Insight"); add("Religion");}};

        assertEquals(type, wizard.getType());
        assertEquals(skills, wizard.getSkills());
    }

}