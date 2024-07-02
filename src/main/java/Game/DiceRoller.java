package Game;

import java.util.Random;

public class DiceRoller {
    int roll;
    public DiceRoller(){

    }

    public int rollDie(int sides) {
        Random randomNum = new Random();
        roll = randomNum.nextInt(sides) + 1;
        return roll;
    }

    public int rollDice(int sides, int numberOfDice) {
        Random randomNum = new Random();
        int total = 0;
        for(int i = 0; i < numberOfDice; i++) {
            total += randomNum.nextInt(sides) + 1;
        }
        return total;
    }

}
