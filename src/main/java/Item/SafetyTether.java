package Item;

public class SafetyTether extends Item {
    private final String name = "Safety Tether";
    private final String type = "armor";
    private final int value = 2;
    public void SpaceJunk() {
        super.setItemName(name);
        super.setItemType(type);
        super.setItemValue(value);
    }

}
