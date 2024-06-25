package Item;

public class SpaceJunk extends Item {
    //treasure chest
    private final String name = "SpaceJunk";
    private final String type = "treasure";
    private Item treasure;

    public void SpaceJunk() {
        super.setItemName("SpaceJunk");
        super.setItemType("Treasure");
        super.setItemValue(treasure.getItemValue());
    }

    public Item getTreasure() {
        return this.treasure;
    }

    public void setTreasure(Item treasure) {
        this.treasure = treasure;
    }
}
