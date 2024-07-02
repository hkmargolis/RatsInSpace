package Game;

import SpaceStation.SpaceStation;

import java.util.ArrayList;

public class Cycle {
    private ArrayList<Part> parts;
    private int totalLevels;
    //4 parts
    public Cycle (SpaceStation spaceStation){
        this.parts = generateParts(spaceStation);

    }

    private ArrayList<Part> generateParts(SpaceStation spaceStation) {
        Part Q1 = new Part(spaceStation);
        Part Q2 = new Part(spaceStation);
        Part Q3 = new Part(spaceStation);
        Part Q4 = new Part(spaceStation);
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

    public boolean isOver(){
        if(parts.isEmpty()) {
            return true;
        }return false;
    }

}
