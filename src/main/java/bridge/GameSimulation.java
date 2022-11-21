package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameSimulation {
    private final List<String> bridge;
    public String answer;
    private int location;
    private List<String> step;
    private boolean success;

    public GameSimulation(List<String> bridge) {
        this.bridge = bridge;
        this.location = 0;
        step = new ArrayList<>();
        this.success = true;
        this.answer = "O";
    }
    public List<String> getbridge() {
        return bridge;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void addStep(String move) {
        step.add(move);
    }

    public String getAnswer() {
        return answer;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getStep() {
        return step;
    }

    public boolean isArrived() {
        return step.size() == bridge.size();
    }

    public void addLocation() {
        this.location += 1;
    }


}
