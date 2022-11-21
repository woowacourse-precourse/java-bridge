package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameSimulation {
    private final List<String> bridge;
    private int station;
    private List<String> step;

    public GameSimulation(List<String> bridge) {
        this.bridge = bridge;
        this.station = 1;
        step = new ArrayList<>();
    }

    public List<String> getbridge() {
        return bridge;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public void addStep(String move) {
        step.add(move);
    }

    public boolean isSuccess() {
        int location = step.size() - 1;
        return step.get(location).equals(bridge.get(location));
    }

    public List<String> getStep() {
        return step;
    }

    public boolean isArrived() {
        return step.size() == bridge.size();
    }

    public void forward() {
        this.station += 1;
    }


}
