package Enemy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallEnemyTest {
    private SmallEnemy enemy;
    @Before
    public void setup() {
        enemy = new SmallEnemy();
    }
    @Test
    public void getEnemyHp() {
        int hp = enemy.getEnemyHp("Space Slime");
        assertEquals(hp, 2);
        hp = enemy.getEnemyHp("Goblin in Spacesuit");
        assertEquals(hp, 2);
        hp = enemy.getEnemyHp("Ice Rat");
        assertEquals(hp, 2);
        hp = enemy.getEnemyHp("Space Centipede");
        assertEquals(hp, 2);
    }
}