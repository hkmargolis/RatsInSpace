package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wizard extends CharacterClass {
    private final String type = "Wizard";
    private final Map<String,Integer> skills = new HashMap<>(){{put("Investigation", 1);put("History", 1);put("Insight", 1);put("Religion", 1); }};
    private final ArrayList<String> names = new ArrayList<String>(){{add("Investigation"); add("History"); add("Insight"); add("Religion");}};
    public Wizard() {
        super.setType(type);
        super.setSkills(skills);
    }
}
