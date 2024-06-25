package Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SuperPack extends Item {
    //potion
    private final String name = "SuperPack";
    private final String type = "consumable";
    private final int value = 1;
    private final Map<String,Integer> superPacks;
    private final ArrayList<String> superPackNames;
    private final int manaCost = 1; //cost 1 to use

    public SuperPack () {
        super.setItemName(name);
        super.setItemType(type);
        super.setItemValue(value);

        superPacks = new HashMap<>();
        superPacks.put("HealPack", 2);
        superPacks.put("StrengthPack", 2);
        superPacks.put("PoisonPack", -2);
        superPacks.put("MaxHealPack", 20);
        superPacks.put("BiteyPack", -2);

        superPackNames = new ArrayList<>();
        superPackNames.add("HealPack");
        superPackNames.add("StrengthPack");
        superPackNames.add("PoisonPack");
        superPackNames.add("MaxHealPack");
        superPackNames.add("BiteyPack");

    }

    public String getRandomSuperPack() {
        int randomIndex = (int)(Math.random() * superPackNames.size());
        String key = superPackNames.get(randomIndex);
;       return key;
    }

    public int getSuperPackValue(String key) {

        return superPacks.get(key);
    }

    public int getManaCost() {
        return this.manaCost;
    }
}
