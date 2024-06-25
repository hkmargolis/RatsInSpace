package Item;

public class PistolGripTool extends Item {
    private final String name = "Pistol Grip";
    private final String type = "weapon";
    private final int value = 2;
    public void SpaceJunk() {
        super.setItemName(name);
        super.setItemType(type);
        super.setItemValue(value);
    }
}
