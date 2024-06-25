package Game;

import java.util.ArrayList;

public class PCFactory {
    PC player;
    public PCFactory(ArrayList<String> pcInfo){
        String name = pcInfo.get(0);
        String characterClass = pcInfo.get(1);
        String characterType = pcInfo.get(2);
        PC player = new PC(name, characterClass, characterType);
    }

    public PC getPC(){
        return this.player;
    }
}
