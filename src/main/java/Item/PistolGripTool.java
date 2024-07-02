package Item;

public class PistolGripTool extends Item {
     final String name = "Pistol Grip";
     final String type = "weapon";
     final int value = 2;
    public void SpaceJunk() {
        super.setItemName(name);
        super.setItemValue(value);
        super.setItemType(type);
    }
}
