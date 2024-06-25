package Enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmallEnemy extends Enemy {
    private final Map<String,Integer> smallEnemies = new HashMap<>(){{put("Space Slime", 2);put("Goblin in Spacesuit", 3);put("Ice Rat", 4);put("Space Centipede", 5); }};
    private final ArrayList<String> names = new ArrayList<String>(){{add("Space Slime"); add("Goblin in Spacesuit"); add("Ice Rat"); add("Space Centipede");}};

    public SmallEnemy() {
        String name = generateRandomName();
        super.setEnemyName(name);
        super.setEnemyHp(getEnemyHp(name));
        this.size = "small";
    }

    private String generateRandomName() {
        int randomIndex = (int)(Math.random() * names.size());
        String key = names.get(randomIndex);
        return key;
    }

    public int getEnemyHp(String key) {
        return smallEnemies.get(key);
    }
}
