package Enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Boss extends Enemy {
    private final Map<String,Integer> bosses = new HashMap<>(){{put("Yggdrasti", 10);put("Asteroid Spider", 12);put("Murder Comet", 14);put("Eye Monger", 16); }};
    private final ArrayList<String> bossNames = new ArrayList<String>(){{add("Yggdrasti"); add("Asteroid Spider"); add("Murder Comet"); add("Eye Monger");}};

    public Boss() {
        String name = generateRandomName();
        super.setEnemyName(name);
        super.setEnemyHp(getBossHp(name));
        super.setEnemySize("large");
    }

    private String generateRandomName() {
        int randomIndex = (int)(Math.random() * bossNames.size());
        String key = bossNames.get(randomIndex);
        return key;
    }

    public int getBossHp(String key) {
        return bosses.get(key);
    }
}
