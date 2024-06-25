package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Thief extends CharacterClass {
    private final String type = "Thief";
    private final Map<String,Integer> skills = new HashMap<>(){{put("Stealth", 1);put("Fast Hands", 1);put("Open Locks", 1);put("Set Traps", 1); }};
    private final ArrayList<String> names = new ArrayList<String>(){{add("Stealth"); add("Fast Hands"); add("Open Locks"); add("Set Traps");}};
    public Thief() {
        super.setType(type);
        super.setSkills(skills);

    }

    public String getType(){
        return this.type;
    }
}
