package Type;

public class PouchedRat extends CharacterType {
    private final String size = "large";
    private final String type = "PouchedRat";

    //good for biter and thief
    public PouchedRat() {
        super.setType(type);
        super.setSize(size);
    }
}
