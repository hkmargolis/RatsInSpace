package Item;

public class Spacesuit extends Item {
    private final String name = "Spacesuit";
    private final String type = "armor";
    private final int value = 4;
    public void SpaceJunk() {
        super.setItemName(name);
        super.setItemType(type);
        super.setItemValue(value);
    }

}
