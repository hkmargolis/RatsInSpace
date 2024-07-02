package Game;

import Item.SpaceJunk;
import SpaceStation.Floor;
import SpaceStation.SpaceStation;
import SpaceStation.Shop;

import java.util.Scanner;

public class Game {
    private DiceRoller diceRoller;
    private Cycle currentCycle;
    private PC player;
    private SpaceStation spaceStation;
    private boolean gameActive;
    private Enemy.Enemy currentEnemy;
    private Part currentPart;
    private Floor currentFloor;
    private Scanner in;
    private CycleFactory cycleFactory;
    public Game (PC player) {
        in = new Scanner(System.in);
        this.diceRoller = new DiceRoller();
        this.spaceStation = SpaceStation.getSpaceStation();
        this.player = player;
        gameActive = true;
        cycleFactory = new CycleFactory(spaceStation);
        currentCycle = cycleFactory.getNextCycle();
        currentPart = currentCycle.getPart();
        currentFloor = currentPart.getFloor();
        currentEnemy = currentFloor.getEnemy();
        getAction();
    }
    public void newGame(){
        spaceStation.resetTotalLevels();
        cycleFactory = new CycleFactory(spaceStation);
        currentCycle = cycleFactory.getNextCycle();
        currentPart = currentCycle.getPart();
        currentFloor = currentPart.getFloor();
        currentEnemy = currentFloor.getEnemy();
    }

    private void handleCycles() {
        if(currentEnemy.getEnemyHp() <=0) {
            currentPart.removeFloor();
        }
        if(currentPart.isOver()){
            currentCycle.removePart();
            currentPart = currentCycle.getPart();
            currentFloor = currentPart.getFloor();
        }
        else if(currentCycle.isOver()){
           cycleFactory.incrementCycle();
           currentCycle = cycleFactory.getNextCycle();
           currentPart = currentCycle.getPart();
           currentFloor = currentPart.getFloor();
        }
        else{
            //go to next floor
            currentFloor = currentPart.getFloor();
        }
            spaceStation.setFloor(currentFloor);
            System.out.println("Spacestation current level: " + spaceStation.getLevel());
            System.out.println("Spacestation total levels: " + spaceStation.getTotalLevels());
            currentEnemy = currentFloor.getEnemy();
    }

    public void goToTopFloorMedBay() {
        System.out.println("\nYou made it to the top floor thanks to that comfy gurney.");
        System.out.println("After a few days in the medbay, you are feeling good as new!\n");
        System.out.println("The front desk kindly informs you that you will receive an invoice in just a few short days.");
        player.resetHitPoints();
        //player.resetMana();
        newGame();
        getAction();
    }

    public void goToTopFloorLevelUp() {
        player.resetHitPoints();
        //player.resetMana();
        newGame();
        getAction();
    }
    public void getAction() {
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
        System.out.println("Hey " + player.getName() + "! There isn't much time--something is coming!\n What do you want to do?\n");
        System.out.println("0 - View your items\n1 - View your character\n2 - Attack\n3 - Flee\n4 - Quit\n");
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        int choice = in.nextInt();
        if(choice == 0) {
            if(player.hasItems()){
                player.displayItems();
            }
            else{
                System.out.println("\nHeck! You have no items!\n");
            }
            getAction();
        }
        else if(choice == 1) {
            player.displayPlayer();
            getAction();
        }
        else if(choice == 2) {
            attack();
        }
        else if(choice == 3) {
            flee();
        }
        else if(choice == 4){
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        else {
            System.out.println("Please enter a valid action.");
        }
    }


    public void attack() {
        System.out.println("\nA " + currentEnemy.getEnemyName() + " approaches!\n");
        Boolean inBattle = true;
        //offer menu options
        while(inBattle) {
            int action = getBattleAction();
            //handle battle
            handleBattle(action);
            //remove part (works as a way to increment through floors);
            if (currentEnemy.getEnemyHp() < 0) {
                //go to next floor in part/cycle
                rollForSpaceJunkOrShop();
                handleCycles();
                getAction();
                inBattle = false;
                break;
            } else if(player.getHitPoints() < 3) {
                System.out.println("Woah there! We better get you to the medbay, LIKE, NOW. Rerouting you to the top floor.");
                goToTopFloorMedBay();
            }else{
                System.out.println("Your hp: " + player.getHitPoints());
                handleNPCAction();
            }
        }

    }

    public int getBattleAction() {
        int choice = -1;
        while(choice < 1 || choice > 4){
            System.out.println("1 - Bite\n2 - Use Item\n3 - Use Skill\n4 - Quit");
            choice = in.nextInt();
        }
        return choice;
    }

    public void handleBattle(int action) {
        int roll = diceRoller.rollDie(6);
        if(action == 1) {
            //bite
            if(roll != 1) {
                biteEnemy();
            }else{
                System.out.println("Your bite missed!");
            }
        }
        else if(action == 2) {
            //use item to attack
            if(player.hasItems() && player.hasMana() && player.hasWeaponsOrSuperPacks()) {
               attackWithItem(roll);
            }
            else if(player.hasItems() == false){
                System.out.println("Dagnabbit! You reached in your pack for your trusty item, but you have no items!");
            }
            else if(player.hasMana() == false) {
                System.out.println("You might want to rest a bit Merlin--you have no mana!");
            }
        }
        else if(action == 3) {
            //use skill
            attackWithSkill();
        }
        else if(action == 4) {
            //quit
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        else {
            System.out.println("Error in Game.handleBattle();");
        }
    }

    public void flee() {
        if(player.hasFleePack() && player.hasMana()){
            System.out.println("You get the heck outta there just in time!");
            getAction();
            player.decrementMana();
            player.dropItem("FleePack");
        }
        else {
            System.out.println("You don't have that SuperPack! You can't flee now!");
            attack();
        }

    }
    public void attackEnemy(Item.Item item) {
        int roll = diceRoller.rollDie(6);
        int enemyHp = currentEnemy.getEnemyHp();
        int itemValue = item.getItemValue();
        if(roll == 2){
            itemValue = itemValue * 2;
        }
        currentEnemy.setEnemyHp(enemyHp - itemValue);
        if(currentEnemy.getEnemyHp() < 0){
            System.out.println("You attacked for " + itemValue + " damage.");
            System.out.println("\nYou slayed the " + currentEnemy.getEnemyName() + "!\n");
            if(player.levelUp(currentEnemy)){
                goToTopFloorLevelUp();
            }
        }
        else{
            System.out.println("You attacked for " + itemValue + " damage.");
            System.out.println("The enemy remains a threat!\n");
        }
    }

    public void biteEnemy() {
        int roll = diceRoller.rollDie(6);
        int enemyHp = currentEnemy.getEnemyHp();
        int damage = 1;
        if(roll == 2) {
            damage = 2; // crit
        }
        currentEnemy.setEnemyHp(enemyHp - damage);
        if(currentEnemy.getEnemyHp() < 0){
            System.out.println("You attacked for " + damage + " damage.");
            System.out.println("\nYou slayed the " + currentEnemy.getEnemyName() + "!\n");
            if(player.levelUp(currentEnemy)){
                goToTopFloorLevelUp();
            }        }
        else{
            System.out.println("You attacked for " + damage + " damage.");
            System.out.println("\nThe enemy remains a threat!");
        }
    }

    public void attackWithItem(int roll){
        Item.Item item = null;
        //use item
        if(player.hasItems()) {
            int choice = -1;
            while(choice < 1 || choice > 4){
                System.out.println("What item would you like to use (1-3)?\n");
                player.displayItems();
                choice = in.nextInt();
                item = player.getItem(choice - 1);
                while(item.getItemType().equals("armor")){
                    System.out.println("You cannot use armor as a weapon.");
                    System.out.println("What item would you like to use (1-3)?\n");
                    player.displayItems();
                    choice = in.nextInt();
                }
            }

            if(item.getItemName().equals("MaxHealPack")) {
                System.out.println("Your health is fully restored! But you are still in battle...");
                player.resetHitPoints();
            }
            else if(item.getItemName().equals("HealPack")) {
                System.out.println("You gain 5 hitpoints! But you are still in battle...");
                player.incrementHP(item.getItemValue());
            }
            else if(item.getItemName().equals("BiteyPack")) {
                System.out.println("You bite!");
                biteEnemy();
                System.out.println("You bite AGAIN!");
                biteEnemy();
            }
            else if(item.getItemName().equals("PoisonPack")) {
                attackEnemy(item);
            }
            else if(item.getItemName().equals("FleePack")) {
                System.out.println("It is too late to flee! Bite for your life!");
                biteEnemy();
            }
            else if(roll != 1) {
                attackEnemy(item);
                player.decrementMana();
            } else{
                System.out.println("Your attack missed!");
            }
            if(!item.getItemName().equals("FleePack") ) {
                player.dropItem(item.getItemName());
            }
        } else {
            if(roll != 1) {
                System.out.println("Heck you have no items! You go in for a chomp!");
                biteEnemy();
            }
            else{
                System.out.println("Your attack missed!");
            }
        }

    }

    public void attackWithSkill(){
        int choice = -1;
        while(choice < 1 || choice > 4){
            System.out.println("What skill would you like to use?\n");
            player.displaySkills();
            choice = in.nextInt();
        }
        int roll = diceRoller.rollDie(6);
        int enemyHp = currentEnemy.getEnemyHp();
        int damage = 1 * roll;
        currentEnemy.setEnemyHp(enemyHp - damage);
        if(currentEnemy.getEnemyHp() < 0){
            System.out.println("You attacked for " + damage + " damage.");
            System.out.println("\nYou slayed the " + currentEnemy.getEnemyName() + "!\n");
            if(player.levelUp(currentEnemy)){
                goToTopFloorLevelUp();
            }        }
        else{
            System.out.println("You attacked for " + damage + " damage.");
            System.out.println("\nThe enemy remains a threat!");
        }
    }

    public void handleNPCAction(){
        System.out.println("\nThe " +  currentEnemy.getEnemyName() + " attacks you!\n -1 hp\n");
        if(currentEnemy.getEnemySize().equals("small")) {
            player.decrementHitPoints(1);
        }
        if(currentEnemy.getEnemySize().equals("medium")){
            player.decrementHitPoints(2);
        }
        if(currentEnemy.getEnemySize().equals("large")) {
            player.decrementHitPoints(3);
        }
    }

    private void rollForSpaceJunkOrShop() {
        int roll = diceRoller.rollDie(6);
        if(roll == 1 || roll == 2) {
            System.out.println("Siiick! You found some SpaceJunk after defeating the enemy.");
            Item.Item treasure = new SpaceJunk();
            System.out.println("You pick through it and find " + treasure.getItemName());
            System.out.println("It is worth " + treasure.getItemValue());
            handleTreasure(treasure);
        }
        else if(roll == 3 || roll == 4) {
            System.out.println("Golly! A shop keeper didn't seem to notice you brutally murdering and beckons you to come check out their wares.\n");
            handleShop();
        }
        else{
            System.out.println("You are one unlucky feller. There ain't no treasure here--and no shop neither!");
        }
    }

    private void handleTreasure(Item.Item treasure){
        int choice = -1;
        while(choice < 1 || choice > 2) {
            System.out.println("\n1 - equip item\n2 - eww hard pass\n");
            choice = in.nextInt();
        }
        if(choice == 1){
            boolean itemsFull = player.itemsFull();
            if(itemsFull) {
                System.out.println("Sorry you already have 3 items equipped. You must drop one to equip this item.");
                handleItems();
            }
            else{
                System.out.println("You equipped the " + treasure.getItemName());
                if(player.alreadyHaveItem(treasure) == false){
                    player.equipItem(treasure);
                }else{
                    System.out.println("Sorry you already have this item equipped.");
                }
            }
        }
        else{
            System.out.println("\nYeah that was gross.\n");
        }
    }

    private void handleItems() {
        int choice = 0;
        boolean handlingItems = true;
        while(handlingItems == true) {
            while (choice < 0|| choice > 1) {
                System.out.println("\nSeems like you got a lot of baggage.\nWould you like to drop an item?\n");
                System.out.println("0 - yes\n1 - no");
                choice = in.nextInt();
            }
            if (choice == 0) {
                player.displayItems();
                choice = -1;
                while (choice < 1 || choice > 3) {
                    System.out.println("Which item would you like to drop?");
                    choice = in.nextInt();
                }
                Item.Item droppedItem = player.dropItem(choice);
                System.out.println("You dropped the " + droppedItem.getItemName());
            } else {
                System.out.println("You opted to keep your baggage for better or for worse.");
                handlingItems = false;
            }
        }
    }

    private void handleShop() {
        Shop shop = new Shop();
        shop.display();
        int request = getPurchaseRequest();
        Item.Item item = shop.getItem(request-1);
        if(player.alreadyHaveItem(item) == true){
            request = getPurchaseRequest();
        }
        else {
            handleShopPurchase(item);
        }
    }

    private int getPurchaseRequest(){
        System.out.println("See anything you like? Of course you must!\nYou are a rat of style, a rat of good taste.\n");
        int choice = 0;
        while(choice < 0 || choice > 1){
            System.out.println("Purchase an item?\n0 - yes\n1 - no");
            choice = in.nextInt();
        }
        switch(choice) {
            case 0:
                while (choice < 1 || choice > 3) {
                    System.out.println("Enter your selection (1-3): ");
                    choice = in.nextInt();
                }
                break;
            case 1:
                System.out.println("\nI see. Do you be kind and close the door behind you on your way out!\n");
                break;
            default:
                break;
        }
        return choice;
    }

    private void handleShopPurchase(Item.Item item){
            boolean itemsFull = player.itemsFull();
            if(itemsFull) {
                System.out.println("Sorry you already have 3 items equipped. You must drop one to equip this item.");
                handleItems();
            }
            else{
                System.out.println("You equipped the " + item.getItemName());
                player.equipItem(item);
            }
    }
}
