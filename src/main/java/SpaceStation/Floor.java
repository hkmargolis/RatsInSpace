package SpaceStation;
import Enemy.Enemy;
import Enemy.SmallEnemy;
import Enemy.MediumEnemy;
import Enemy.Boss;
public class Floor {
    private int level;
    private Enemy enemy;

    public Floor(SpaceStation spaceStation){
        this.level = spaceStation.getTotalLevels() + 1;
        spaceStation.incrementTotalLevels();
        System.out.println("Floor level " + this.level);
        this.enemy = generateEnemy(level);
        System.out.println("Enemy: " + enemy.getEnemyName());
    }

    private Enemy generateEnemy(int level) {
        Enemy enemy = null;
        if(level % 10 == 0) {
            //boss every 10 floors
            enemy = new Boss();
        } else if(level % 5 == 0){
            //medium enemy every 5 floors
            enemy = new MediumEnemy();
        }else{
            //small enemy every floor
            enemy = new SmallEnemy();
        }
        return enemy;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}
