package Game;

import java.util.ArrayList;

public class PCFactory {
    PC player;
    public PCFactory(ArrayList<String> pcInfo){
        String name = pcInfo.get(0);
        String cc = pcInfo.get(1);
        String ct = pcInfo.get(2);
        this.player = new PC(name, cc, ct);
    }

    public PC getPC(){
        return this.player;
    }

    public void printPC() {
        System.out.println("Name: " + player.getName());
        System.out.println("Class: " + player.getCharacterClass());
        System.out.println("Type: " + player.getCharacterType());
    }
}
