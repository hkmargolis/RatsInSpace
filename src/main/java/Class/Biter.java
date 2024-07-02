package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Biter extends CharacterClass {

    private final String type = "Biter";
    //private final Map<String,Integer> skills = new HashMap<>(){{put("Scratch", 1);put("Bite", 1);put("Tail Whip", 1);put("Dodge", 1); }};
    private final ArrayList<String> skills = new ArrayList<String>(){{add("Scratch"); add("Bite"); add("Tail Whip"); add("Dodge");}};
    public Biter() {
        super.setType(type);
        super.setSkills(skills);
    }

}
