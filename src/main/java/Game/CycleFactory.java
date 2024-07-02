package Game;

public class CycleFactory {
    private Cycle[] cycles;
    private int currentCycle;

    public CycleFactory(SpaceStation.SpaceStation spaceStation) {
        cycles = new Cycle[5];
        for(int i = 0; i < cycles.length; i++) {
            cycles[i] = new Cycle(spaceStation);
        }
        currentCycle = 0;
    }
    public Cycle getNextCycle(){
        return cycles[currentCycle];
    }

    public void incrementCycle() {
        currentCycle++;
    }
}
