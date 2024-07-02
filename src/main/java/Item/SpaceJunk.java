package Item;

import java.security.spec.PSSParameterSpec;
import java.util.ArrayList;

public class SpaceJunk extends Item {
    //treasure chest
    private final ArrayList<Item> allItems = new ArrayList<>(){{add(new PistolGripTool()); add(new SafetyTether()); add(new Spacesuit()); add(new SuperPack());}};

    public SpaceJunk(){
        generateSpaceJunk();
    }

    public void generateSpaceJunk(){
        int randomIndex = (int)(Math.random() * 4) + 1;
        switch (randomIndex) {
            case 1:
                PistolGripTool pg = new PistolGripTool();
                super.setItemName(pg.name);
                super.setItemValue(pg.value);
                super.setItemType(pg.type);
                break;
            case 2:
               SafetyTether st = new SafetyTether();
                super.setItemName(st.name);
                super.setItemValue(st.value);
                super.setItemType(st.type);
               break;
            case 3:
                Spacesuit ss = new Spacesuit();
                super.setItemName(ss.name);
                super.setItemValue(ss.value);
                super.setItemType(ss.type);
                break;
            case 4:
                SuperPack sp = new SuperPack();
                super.setItemName(sp.name);
                super.setItemValue(sp.value);
                super.setItemType(sp.type);
                break;
            default:
                break;
        }
    }

}
