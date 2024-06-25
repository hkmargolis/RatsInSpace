package Game;

import SpaceStation.Floor;
import SpaceStation.SpaceStation;

import java.util.Scanner;

public class Game {
    private DiceRoller diceRoller;
    private Cycle cycle;
    private PC player;
    private SpaceStation spaceStation;
    private boolean gameActive;
    private Enemy.Enemy currentEnemy;
    public Game (PC player) {
        this.diceRoller = new DiceRoller();
        this.spaceStation = new SpaceStation();
        this.player = player;
        currentEnemy = null;
        gameActive = true;
        newGame();
        getAction();
    }

    public void newGame() {
        this.cycle = new Cycle();
    }

    public void getAction() {
        System.out.println("Hey " + player.getName() + "! There isn't much time--someone is coming!\n What do you want to do?");

        Scanner in = new Scanner(System.in);
        System.out.println("0 - View your items\n1 - Attack\n2 - Flee\n3 - Quit");
        int choice = in.nextInt();
        if(choice == 0) {
            player.viewItems();
            getAction();
        }
        else if(choice == 1) {
            attack();
        }
        else if(choice == 2) {
            //TODO
            System.out.println("Sorry fleeing is not an option!");
            //flee();
            attack();
        }
        else if(choice == 3) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        else {
            System.out.println("Please enter a valid action.");
        }
        in.close();
    }


    public void attack() {
        // get first part
        Part currentPart = cycle.getPart();
        Floor currentFloor = currentPart.getFloor();
        System.out.println("Floor " + currentFloor.getCurrentLevel());
        currentEnemy = currentFloor.getEnemy();
        System.out.println("A " + currentEnemy.getEnemyName() + " approaches!");
        //offer menu options
        int action = getBattleAction();
        //handle battle
        handleBattle(action);
        handleNPCAction();
        //remove part (works as a way to increment through floors);
        if(currentEnemy.getEnemyHp() < 0){
            //go to next floor in part/cycle
            currentPart.removeFloor();
            getAction();
        }
        else {
            attack();
        }


    }

    public int getBattleAction() {
        Scanner in = new Scanner(System.in);
        int choice = -1;
        while(choice < 1 || choice > 3){
            System.out.println("1 - Bite\n2 - Use Item\n3 - Quit");
            choice = in.nextInt();
        }
        in.close();
        return choice;
    }

    public void handleBattle(int action) {
        if(action == 1) {
            biteEnemy();
        }
        else if(action == 2) {
            if(player.hasItems()) {
                Item.Item item = player.useItem();
                attackEnemy(item);
            } else {
                biteEnemy();
            }
        }
        else if(action == 3) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        else {
            System.out.println("Error in Game.handleBattle();");
        }
    }

    public void attackEnemy(Item.Item item) {
        int enemyHp = currentEnemy.getEnemyHp();
        int itemValue = item.getItemValue();
        currentEnemy.setEnemyHp(enemyHp - itemValue);
        if(currentEnemy.getEnemyHp() < 0){
            System.out.println("You slayed the " + currentEnemy.getEnemyName() + "!");
        }
        else{
            System.out.println("The enemy remains a threat!");
        }
    }

    public void biteEnemy() {
        int enemyHp = currentEnemy.getEnemyHp();
        currentEnemy.setEnemyHp(enemyHp - 1);
        if(currentEnemy.getEnemyHp() < 0){
            System.out.println("You slayed the " + currentEnemy.getEnemyName() + "!");
        }
        else{
            System.out.println("The enemy remains a threat!");
        }
    }

    public void handleNPCAction(){
        System.out.println("The " +  currentEnemy.getEnemyName() + " attacks you!\n -1 hp");
        player.decrementHitPoints(1);
    }
}
