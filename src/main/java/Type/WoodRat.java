package Type;

public class WoodRat extends CharacterType {
    private final String size = "small";
    private final String type = "WoodRat";

    //good for wizard and thief
    public WoodRat() {
        super.setType(type);
        super.setSize(size);

    }

}
