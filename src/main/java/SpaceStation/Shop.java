package SpaceStation;

import Item.Item;
import java.util.ArrayList;

public class Shop extends SpaceStation {
    ArrayList<Item> items; //total of 3 random items

    public Shop(){
        this.items = generateItems();
    }

    private ArrayList<Item> generateItems() {
        return new ArrayList<Item>();
    }

}
