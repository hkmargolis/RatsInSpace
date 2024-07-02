package Game;

import Item.Item;
import Item.PistolGripTool;
import Item.SafetyTether;
import Item.Spacesuit;
import Item.SuperPack;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PCTest {
    private PC thief;
    private PC biter;
    private PC wizard;


    @Before
    public void setup() {
        biter = new PC("Beryl", "1", "1");
        thief = new PC("Tom", "2", "1");
        wizard = new PC("Wren", "3", "1");

    }

    @Test
    public void setCharacterStats() {
        thief.setCharacterStats();
        assertEquals(thief.getSpeed(), 30);

        wizard.setCharacterStats();
        assertEquals(wizard.getMana(), 15);

        biter.setCharacterStats();
        assertEquals(biter.getDefense(), 15);
        assertEquals(biter.getAttack(), 15);

    }

    @Test
    public void equipItem() {
        Item item = new PistolGripTool();
        biter.equipItem(item);
        boolean equipped = biter.alreadyHaveItem(item);
        assertEquals(equipped, true);
    }

    @Test
    public void alreadyHaveItem() {
        Item item = new PistolGripTool();
        biter.equipItem(item);
        boolean hasItem = biter.alreadyHaveItem(item);
        assertEquals(hasItem, true);
    }

    @Test
    public void itemsFull() {
        Item item2 = new Spacesuit();
        Item item3 = new SafetyTether();
        biter.equipItem(item2);
        biter.equipItem(item3);
        boolean full = biter.itemsFull();
        assertEquals(full, true);
    }

    @Test
    public void dropItem() {
        Item item3 = new SafetyTether();
        biter.dropItem(item3.getItemName());
        ArrayList<Item> items = biter.getAllItems();
        boolean itemEquipped = items.contains(item3);
        assertEquals(itemEquipped, false);

    }

    @Test
    public void hasWeaponsOrSuperPacks() {
        Item item = new PistolGripTool();
        biter.equipItem(item);
        boolean hasWeapon = biter.hasWeaponsOrSuperPacks();
        assertEquals(hasWeapon, true);

        Item item2 = new SuperPack();
        biter.equipItem(item2);
        boolean hasSuperPack = biter.hasWeaponsOrSuperPacks();
        assertEquals(hasSuperPack, true);



    }

    @Test
    public void dropAllItems() {
        biter.dropAllItems();
        boolean hasItems = biter.hasItems();
        assertEquals(hasItems, false);
    }

    @Test
    public void getAllItems() {
        Item item1 = new PistolGripTool();
        Item item2 = new Spacesuit();
        Item item3 = new SafetyTether();
        biter.equipItem(item1);
        biter.equipItem(item2);
        biter.equipItem(item3);
        ArrayList<Item> testItems = new ArrayList<>(){{add(item1); add(item2); add(item3);}};
        assertEquals(biter.getAllItems(), testItems);
    }

    @Test
    public void getItemIndex() {
        biter.equipItem(new PistolGripTool());
        Item item = biter.getItem(0);
        int index = biter.getItemIndex(item);
        assertEquals(index, 0);
    }


    @Test
    public void getItem() {
        biter.dropAllItems();
        Item item = new PistolGripTool();
        biter.equipItem(item);
        Item item1 = biter.getItem(0);
        assertEquals(item1.getItemType(), "Pistol Grip");

    }

    @Test
    public void getName() {
        String name = biter.getName();
        assertEquals(name, "Beryl");
    }
    @Test
    public void hasItems() {
        Item item = new PistolGripTool();
        biter.equipItem(item);
        boolean hasItems = biter.hasItems();
        assertEquals(hasItems, true);
    }

    @Test
    public void getHitPoints() {
        biter.resetHitPoints();
        int hp = biter.getHitPoints();
        assertEquals(hp, 20);
    }

    @Test
    public void setHitPoints() {
        biter.setHitPoints(5);
        int hp = biter.getHitPoints();
        assertEquals(hp, 5);
    }

    @Test
    public void decrementHitPoints() {
        biter.resetHitPoints();
        biter.decrementHitPoints(1);
        int hp = biter.getHitPoints();
        assertEquals(hp, 19);

    }

    @Test
    public void getCharacterClass() {
        String cc = biter.getCharacterClass();
        assertEquals(cc, "bite");
    }

    @Test
    public void getCharacterType() {
        String ct = biter.getCharacterType();
        assertEquals(ct, "PouchedRat");
    }

    @Ignore
    public void displayItems() {
    }

    @Ignore
    public void displayPlayer() {
    }

    @Ignore
    public void displaySkills() {
    }

    @Test
    public void hasFleePack() {
        biter.dropAllItems();
        Item fleepack = new SuperPack("FleePack", 0);
        biter.equipItem(fleepack);
        boolean hasFleePack = false;
        if(biter.hasFleePack()){
            hasFleePack = true;
        }
        assertEquals(hasFleePack, true);
    }

    @Test
    public void hasMana() {
        boolean hasMana = biter.hasMana(); //all player start with 5
        assertEquals(hasMana, true);
    }

    @Test
    public void decrementMana() {
        biter.decrementMana();
        int mana = biter.getMana();
        assertEquals(mana, 4);
    }

    @Test
    public void isDead() {
        biter.resetHitPoints();
        boolean dead = biter.isDead();
        assertEquals(dead, false);
        biter.setHitPoints(-1);
        dead = biter.isDead();
        assertEquals(dead, true);

    }

    @Test
    public void resetHitPoints() {
        biter.setHitPoints(5);
        int hpBefore = biter.getHitPoints();
        assertEquals(hpBefore, 5);
        biter.resetHitPoints();
        int hpAfter = biter.getHitPoints();
        assertEquals(hpAfter, 20);
    }

    @Test
    public void incrementXP() {
        int xp = biter.getXP();
        assertEquals(xp,0);
        biter.incrementXP(10);
        xp = biter.getXP();
        assertEquals(xp, 10);
    }

    @Test
    public void incrementLevel() {
        int level = biter.getLevel();
        assertEquals(level,1);
        biter.incrementLevel();
        level = biter.getLevel();
        assertEquals(level,2);
    }

    @Test
    public void getXP() {
        int xp = wizard.getXP();
        assertEquals(xp, 0); //wizard hasn't earned any xp yet
    }

    @Test
    public void setLevel() {
        biter.setLevel(10);
        int level = biter.getLevel();
        assertEquals(level, 10);
    }

    @Test
    public void incrementHP() {
        biter.resetHitPoints();
        biter.incrementHP(5);
        int hp = biter.getHitPoints();
        assertEquals(hp, 25);

    }
}