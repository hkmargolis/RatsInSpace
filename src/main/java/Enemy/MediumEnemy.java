package Enemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MediumEnemy extends Enemy{
        private final Map<String,Integer> mediumEnemies = new HashMap<>(){{put("Gadabout", 6);put("Eldritch lich", 7);put("Goon balloon", 8);put("Eye Monger", 9);}};
        private final ArrayList<String> names = new ArrayList<String>(){{add("Gadabout"); add("Eldritch lich"); add("Goon balloon"); add("Eye Monger");}};

        public MediumEnemy() {
            String name = generateRandomName();
            super.setEnemyName(name);
            super.setEnemyHp(getEnemyHp(name));
            super.setEnemySize("medium");
        }

        private String generateRandomName() {
            int randomIndex = (int)(Math.random() * names.size());
            String key = names.get(randomIndex);
            return key;
        }

        public int getEnemyHp(String key) {
            return mediumEnemies.get(key);
        }

}
