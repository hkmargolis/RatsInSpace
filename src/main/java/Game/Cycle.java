package Game;

import java.util.ArrayList;

public class Cycle {
    private ArrayList<Part> parts;
    //4 parts
    public Cycle (){
        this.parts = generateParts();

    }

    private ArrayList<Part> generateParts() {
        Part Q1 = new Part();
        Part Q2 = new Part();
        Part Q3 = new Part();
        Part Q4 = new Part();
        return new ArrayList<>(){{add(Q1); add(Q2); add(Q3); add(Q4);}};
    }

    public Part getPart() {
        if(!parts.isEmpty()){
            return this.parts.get(0);
        }else{
            System.out.println("No more parts in this cycle to get.");
            return null;
        }
    }

    public void removePart() {
        if(!parts.isEmpty()){
            this.parts.remove(0);
        } else {
            System.out.println("No more parts in this cycle to remove.");
        }
    }

}
