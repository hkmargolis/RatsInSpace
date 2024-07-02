package Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SuperPack extends Item {
    //potion
     String name;
     int value;
     final String type = "SuperPack";
    private final Map<String,Integer> superPacks = new HashMap<>(){{
        put("HealPack", 5);
        put("StrengthPack", 2);
        put("PoisonPack", 5);
        put("MaxHealPack", 20);
        put("BiteyPack", 2);
        put("FleePack", 0);
        }};
    private final ArrayList<String> superPackNames = new ArrayList<>(){{
        add("HealPack");
        add("StrengthPack");
        add("PoisonPack");
        add("MaxHealPack");
        add("BiteyPack");
    }};
    private final int manaCost = 1; //cost 1 to use

    public SuperPack () {
        generateRandomSuperPack();
    }
    public SuperPack(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void generateRandomSuperPack() {
        int randomIndex = (int)(Math.random() * superPackNames.size());
        name = superPackNames.get(randomIndex);
        super.setItemName(name);
        value = getSuperPackValue(name);
        super.setItemValue(value);
        super.setItemType(type);
    }

    public int getSuperPackValue(String name) {
        return superPacks.get(name);
    }

    public int getManaCost() {
        return this.manaCost;
    }
}
