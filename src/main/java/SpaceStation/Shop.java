package SpaceStation;

import Item.Item;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import Item.SuperPack;
import Item.SpaceJunk;
import Item.PistolGripTool;
import Item.SafetyTether;
import Item.Spacesuit;

public class Shop {
    private ArrayList<Item> items; //total of 3 random items

    public Shop(){
        this.items = generateItems();
    }

    private ArrayList<Item> generateItems() {
        Item item1 = new SpaceJunk();
        Item item2 = new SpaceJunk();
        Item item3 = new SpaceJunk();

        return new ArrayList<Item>(){{add(new SpaceJunk()); add(new SpaceJunk()); add(new SpaceJunk());}};
    }

    public void display(){
        int count = 1;
        System.out.println("****************************************");
        System.out.println("|                 SHOP                 |");
        System.out.println("****************************************");

        for(Item item : items){
            System.out.println(count + " - " + item.getItemName());
            System.out.println("Type: " + item.getItemType());
            System.out.println("Value " + item.getItemValue() + "\n");
            count++;
        }
        System.out.println("****************************************");

    }

    public Item getItem(int index){
        return items.get(index);
    }
}
