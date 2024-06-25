package SpaceStation;
import Enemy.Enemy;
import Enemy.SmallEnemy;
import Enemy.MediumEnemy;
import Enemy.Boss;
public class Floor extends SpaceStation {
    private int level;
    private Enemy enemy;

    public Floor(){
        this.level = super.getCurrentLevel() + 1;
        this.enemy = generateEnemy(level);
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

}
