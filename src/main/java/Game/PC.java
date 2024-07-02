package Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import Item.Item;
import Class.CharacterClass;
import Class.Biter;
import Class.Thief;
import Class.Wizard;
import Type.FancyRat;
import Type.PouchedRat;
import Type.WoodRat;
import Type.CharacterType;

public class PC {
    //player character
    private static final int MAX_HIT_POINTS = 20;
    private static final int INIT_ATTACK = 5;
    private static final int INIT_MANA= 5;
    private static final int INIT_DEFENSE = 5;
    private static final int INIT_SPEED = 20; //20 ft
    private static final int PROFICIENCY_BONUS = 10;
    private CharacterClass characterClass;
    private CharacterType characterType;
    private String name;
    private int level;
    private ArrayList<Item> items;
    private ArrayList<String> skills;
    private ArrayList<String> tempStatusEffects;
    private String permanentStatusEffect;
    private int attack;
    private int hitPoints; //physical
    private int mana; //magic
    private int defense;
    private int speed;
    private Scanner in;
    public PC(String name, String cc, String ct) {
        in = new Scanner(System.in);
        this.name = name;
        this.items = new ArrayList<Item>();
        this.speed = INIT_SPEED;
        this.mana = INIT_MANA;
        //generate character class and type
        setCharacterClass(cc);
        setCharacterType(ct);
        setCharacterStats();
        this.hitPoints = MAX_HIT_POINTS;
        this.level = 1;
        //assign proficiency bonus to stats based on character class


    }

    private void setCharacterClass(String cc) {
        if(cc.equals("1")) {
            this.characterClass = new Biter();
            this.skills = characterClass.getSkills();
        }
        else if(cc.equals("2")) {
            this.characterClass = new Thief();
            this.skills = characterClass.getSkills();

        }
        else if(cc.equals("3")){
            this.characterClass = new Wizard();
            this.skills = characterClass.getSkills();

        }
        else {
            //TODO
            System.out.println("Error in PC.setCharacterClass()");
        }
    }

    private void setCharacterType(String ct) {
        if(ct.equals("1")) {
            this.characterType = new PouchedRat();
        } else if(ct.equals("2")) {
            this.characterType = new FancyRat();
        } else if(ct.equals("3")) {
            this.characterType = new WoodRat();
        }
        else{
            //TODO
            System.out.println("Error in PC.setCharacterType()");
        }
    }

    public void setCharacterStats() {

        if(characterClass.getType().equals("Thief")) {
            this.speed += PROFICIENCY_BONUS;

        }else if(characterClass.getType().equals("Wizard")) {
            this.mana += PROFICIENCY_BONUS;

        }else if(characterClass.getType().equals("Biter")) {
            this.defense += PROFICIENCY_BONUS;
            this.attack += PROFICIENCY_BONUS;

        } else {
            //TODO
            System.out.println("Error in PC.setPCStats()");
        }

    }

    public void equipItem(Item item) {
        this.items.add(item);
        //temporary status effect
        if(item.getItemName().equals("Spacesuit")) {
            hitPoints += item.getItemValue();
        }
        //temporary status effect
        if(item.getItemName().equals("Safety Tether")) {
            hitPoints += item.getItemValue();
        }
    }
    public boolean alreadyHaveItem(Item item) {
        for(Item i : items){
            if(i.getItemName().equals(item.getItemName())){
                return true;
            }
        }return false;
    }
    public boolean itemsFull(){
        if(items.size() == 3){
            return true;
        }
        return false;
    }

    public Item dropItem(int index) {
        Item item = this.items.get(index);
        this.items.remove(index - 1);
        if(item.getItemName().equals("Spacesuit")) {
            //temporary status effect
            hitPoints -= item.getItemValue();
        }
        if(item.getItemName().equals("Safety Tether")) {
            hitPoints -= item.getItemValue();
        }
        return item;
    }

    public void dropItem(String name) {
        for(Item item : items) {
            if(item.getItemName().equals(name)) {
                items.remove(item);
                if(item.getItemName().equals("Spacesuit")) {
                    //temporary status effect
                    hitPoints += item.getItemValue();
                }
                if(item.getItemName().equals("Safety Tether")) {
                    hitPoints += item.getItemValue();
                }
            }

        }

    }
    public boolean hasWeaponsOrSuperPacks(){
        for(Item item : items) {
            if(item.getItemType().equals("weapon") || item.getItemType().equals("SuperPack")) {
                return true;
            }
        }return false;
    }
    public void dropAllItems() {
        this.items.clear();
    }

    public ArrayList<Item> getAllItems() {
            return this.items;
    }

    public int getItemIndex(Item item) {
        return items.indexOf(item);
    }

    public Item getItem(int index) {
        return this.items.get(index);
    }

    public String getName() {
        return this.name;
    }

    public void bite(){

    }
    public boolean hasItems(){
        if(items.isEmpty()){
            return false;
        }return true;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }
    public void setHitPoints(int points){
        this.hitPoints = points;
    }
    public void decrementHitPoints(int points){
        this.hitPoints -= points;
    }

    public String getCharacterClass() {
        return this.characterClass.getType();
    }

    public String getCharacterType() {
        return this.characterType.getType();
    }

    public void displayItems() {
        int count = 1;
        System.out.println("\n--- Your Equipped Items ---\n");
        for(Item item : items){
            System.out.println(count + " - " + item.getItemName());
            System.out.println("Type    " + item.getItemType());
            System.out.println("Value   " + item.getItemValue() + "\n");
            count++;
        }
        System.out.println("-----------------------------\n");
    }

    public void displayPlayer(){
        System.out.println("\n------- Your Character ------");
        System.out.println("Name    " + this.name);
        System.out.println("-----------------------------");
        System.out.println("Class   " + this.characterClass.getType());
        System.out.println("Type    " + this.characterType.getType());
        System.out.println("-----------------------------");
        System.out.println("Attack  " + this.attack);
        System.out.println("Mana    " + this.mana);
        System.out.println("HP      " + this.hitPoints);
        System.out.println("Defense " + this.defense);
        System.out.println("Speed   " + this.speed);
        System.out.println("-----------------------------");
        System.out.println("Skills  " + skills.toString());
        System.out.println("-----------------------------\n");
    }

    public void displaySkills(){
        System.out.println("\n---------- Skills ---------");
        for(int i = 0; i < skills.size(); i++) {
            System.out.println(i+1 + " - " + skills.get(i));
        }
        System.out.println("-----------------------------\n");
    }

    public boolean hasFleePack(){
        if(items.toString().contains("FleePack")){
            return true;
        }
        return false;
    }
    public boolean hasMana(){
        if(mana > 0){
            return true;
        }
        else return false;
    }

    public void decrementMana(){
        this.mana--;
    }

    public boolean isDead(){
        if(hitPoints < 0) {
            return true;
        }return false;
    }

    public void resetHitPoints() {
        hitPoints = 20;
    }
}
