package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CharacterClass {
    private String type;
    private ArrayList<String> skills;
    public CharacterClass() {
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ArrayList<String> getSkills() {
        return this.skills;
    }
    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

}
