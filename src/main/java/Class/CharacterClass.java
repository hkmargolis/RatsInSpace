package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharacterClass {
    private String type;
    private Map<String,Integer> skills;
    public CharacterClass() {
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Map<String,Integer> getSkills() {
        return this.skills;
    }
    public void setSkills(Map<String,Integer> skills) {
        this.skills = skills;
    }

}
