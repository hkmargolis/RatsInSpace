package Enemy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BossTest {

    private Boss boss;

    @Before
    public void setup() {
        boss = new Boss();
    }
    @Test
    public void getBossHp() {
        int hp = boss.getBossHp("Yggdrasti");
        assertEquals(hp, 10);
        hp = boss.getBossHp("Asteroid Spider");
        assertEquals(hp, 12);
        hp = boss.getBossHp("Murder Comet");
        assertEquals(hp, 14);
        hp = boss.getBossHp("Eye Monger");
        assertEquals(hp, 16);
    }
}