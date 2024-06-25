package Type;

public class FancyRat extends CharacterType {
    private final String size = "medium";
    private final String type = "FancyRat";

    //good for wizard and biter
    public FancyRat() {
        super.setType(type);
        super.setSize(size);

    }

}
