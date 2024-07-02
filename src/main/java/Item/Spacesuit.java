package Item;

public class Spacesuit extends Item {
     final String name = "Spacesuit";
     final String type = "armor";
     final int value = 4;
    public void SpaceJunk() {
        super.setItemName(name);
        super.setItemValue(value);
        super.setItemType(type);
    }

}
