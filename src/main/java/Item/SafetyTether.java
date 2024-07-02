package Item;

public class SafetyTether extends Item {
     final String name = "Safety Tether";
     final String type = "armor";
     final int value = 2;
    public void SpaceJunk() {
        super.setItemName(name);
        super.setItemValue(value);
        super.setItemType(type);
    }

}
