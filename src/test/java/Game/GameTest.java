package Game;

import Enemy.Boss;
import Enemy.MediumEnemy;
import Enemy.SmallEnemy;
import Item.PistolGripTool;
import Item.SuperPack;
import SpaceStation.SpaceStation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private SpaceStation spaceStation;
    private PC player;
    private DiceRoller roller;
    @Before
    public void setup() {
        spaceStation = SpaceStation.getSpaceStation();
        roller = new DiceRoller();
        player = new PC("Merlin", "1", "1");
    }
    @Ignore
    public void newGame() {
//        spaceStation.resetTotalLevels();
//        cycleFactory = new CycleFactory(spaceStation);
//        currentCycle = cycleFactory.getNextCycle();
//        currentPart = currentCycle.getPart();
//        currentFloor = currentPart.getFloor();
//        currentEnemy = currentFloor.getEnemy();
        int level = spaceStation.getLevel(); //returns current floor
        assertEquals(level, 1);
    }

    @Ignore
    public void goToTopFloorMedBay() {
    }

    @Ignore
    public void goToTopFloorLevelUp() {
    }

    @Ignore
    public void getAction() {
    }

    @Ignore
    public void attack() {

    }

    @Ignore
    public void getBattleAction() {
    }

    @Ignore
    public void handleBattle() {
    }

    @Ignore
    public void flee() {

    }

    @Ignore
    public void attackEnemy() {
        Item.Item item = new PistolGripTool();
        int roll = 2;
        Enemy.Enemy currentEnemy = new SmallEnemy();
            int enemyHp = currentEnemy.getEnemyHp();
            int itemValue = item.getItemValue();
            if(roll == 2){
                itemValue = itemValue * 2;
            }
            currentEnemy.setEnemyHp(enemyHp - itemValue);
//            if(currentEnemy.getEnemyHp() < 0){
//                System.out.println("You attacked for " + itemValue + " damage.");
//                System.out.println("\nYou slayed the " + currentEnemy.getEnemyName() + "!\n");
//                if(player.levelUp(currentEnemy)){
//                    goToTopFloorLevelUp();
//                }
//            }
//            else{
//                System.out.println("You attacked for " + itemValue + " damage.");
//                System.out.println("The enemy remains a threat!\n");
//            }

            assertEquals(enemyHp, enemyHp - itemValue);
        }

    @Test
    public void biteEnemy() {
    }

    @Test
    public void attackWithItem() {
    }

    @Test
    public void attackWithSkill() {
    }

    @Test
    public void handleNPCAction() {
        Enemy.Enemy enemy1 = new SmallEnemy();
        Enemy.Enemy enemy2 = new MediumEnemy();
        Enemy.Enemy enemy3 = new Boss();
        int hp1 = player.getHitPoints(); //20
        int hp2 = 0, hp3=0, hp4=0;

        if(enemy1.getEnemySize().equals("small")) {
            player.decrementHitPoints(1);
        }
        hp2 = player.getHitPoints(); //19
        assertEquals(hp1-1, hp2);

        if(enemy2.getEnemySize().equals("medium")){
            player.decrementHitPoints(2);
        }
        hp3 = player.getHitPoints(); //17
        assertEquals(hp2-2, hp3);

        if(enemy3.getEnemySize().equals("large")) {
            player.decrementHitPoints(3);
        }
        hp4 = player.getHitPoints();//14
        assertEquals(hp3-3, hp4);
    }
}