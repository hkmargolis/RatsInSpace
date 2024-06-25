package Game;

import java.util.ArrayList;
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
    public PC(String name, String characterClass, String characterType) {
        this.name = name;
        //generate character class and type
        setCharacterClass(characterClass);
        setCharacterType(characterType);
        setCharacterStats();
        this.hitPoints = MAX_HIT_POINTS;
        this.level = 1;
        //assign proficiency bonus to stats based on character class


    }

    private void setCharacterClass(String characterClass) {
        if(characterClass.equals("Biter")) {
            this.characterClass = new Biter();
        }
        else if(characterClass.equals("Thief")) {
            this.characterClass = new Thief();
        }
        else if(characterClass.equals("Wizard")){
            this.characterClass = new Wizard();
        }
        else {
            //TODO
            System.out.println("Error in PC.setCharacterClass()");
        }
    }

    private void setCharacterType(String characterType) {
        if(characterType.equals("FancyRat")) {
            this.characterType = new FancyRat();
        } else if(this.characterType.equals("PouchedRat")) {
            this.characterType = new PouchedRat();
        } else if(this.characterType.equals("WoodRat")) {
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
        if(this.items.isEmpty()){
            this.items.add(item);
        }
        if(this.items.size() < 3) {
            this.items.add(item);
        }
        else{
            System.out.println("Sorry you already have 3 items equipped. You must drop one to equip this item.");
        }

    }

    public void dropItem(Item item) {
        this.items.remove(item);
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
    public Item useItem(){
        System.out.println("Your items: " + this.items.toString());
        System.out.println("Enter 1, 2 or 3 to select item you want to use.\n");
        Scanner in = new Scanner(System.in);
        int item = in.nextInt();
        in.close();
        return items.get(item);

    }

    public void viewItems(){
        System.out.println(items.toString());
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
    //method for temporary status effect
    //method for permanent status effect
}
