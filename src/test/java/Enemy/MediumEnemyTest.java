package Enemy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediumEnemyTest {

    private MediumEnemy enemy;

    @Before
    public void setup(){
        enemy = new MediumEnemy();
    }
    @Test
    public void getEnemyHp() {
        int hp = enemy.getEnemyHp("Gadabout");
        assertEquals(hp, 6);
        hp = enemy.getEnemyHp("Eldritch lich");
        assertEquals(hp, 7);
        hp = enemy.getEnemyHp("Goon balloon");
        assertEquals(hp, 8);
        hp = enemy.getEnemyHp("Eye Monger");
        assertEquals(hp, 9);
    }
}