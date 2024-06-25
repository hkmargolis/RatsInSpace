

import Game.PCFactory;
import Game.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        welcomeMenu();
        if(in.nextInt() == 1){
            ArrayList<String> pcInfo = getPCInfo();
            PCFactory pcFactory = new PCFactory(pcInfo);
            Game game = new Game(pcFactory.getPC());
        } else{
            in.close();
            System.exit(0);
        }

    }

    public static void welcomeMenu() {
        System.out.println("----------------------\n" +
                "                       (\\,;,/)\n" +
                "RATS IN SPACE           (o o)\\//,\n" +
                "***************          \\ /     \\,\n" +
                "A SPACE-STATION          `+'(  (   \\    )\n" +
                "DUNGEON CRAWLER             //  \\   |_./\n" +
                "                          '~' '~----' \n" +
                "----------------------");
        System.out.println("The Muri Space-Station is under attack, and we need your help!");
        System.out.println("1 - Start\n0 - Quit");
    }

    private static ArrayList<String> getPCInfo() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a character name: ");
        String name = in.next();
        System.out.println("Enter a character class:\n1 - Biter\n2 - Thief\n3 - Wizard");
        int characterClass = -1;
        while(characterClass < 1 || characterClass > 3){
            System.out.println("Enter a character class:\n1 - Biter\n2 - Thief\n3 - Wizard");
            characterClass = in.nextInt();
        }
        System.out.println("Enter a character type:\n 1 - PouchedRat\n 2 - FancyRat\n 3 - WoodRat");
        int characterType = -1;
        while(characterType < 1 || characterType > 3){
            System.out.println("Enter a character type:\n 1 - PouchedRat\n 2 - FancyRat\n 3 - WoodRat");
            characterType = in.nextInt();
        }
        String cc = String.valueOf(characterClass);
        String ct = String.valueOf(characterType);
        return new ArrayList<>(){{add(name); add(cc); add(ct);}};

    }

}