package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameSimulation {
    private final List<List<String>> bridge;
    public String answer;
    private int location;
    private List<String> step;
    private boolean success;

    public GameSimulation() {
        this.bridge = new ArrayList<>();
        this.location = 0;
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();
        step = new ArrayList<>();
        bridge.add(up);
        bridge.add(down);
        this.success = true;
        this.answer = "O";
    }

    public void print(String direction, String answer) {
        if (direction.equals("U")) {
            bridge.get(0).add(answer);
            bridge.get(1).add(" ");
            return;
        }
        bridge.get(1).add(answer);
        bridge.get(0).add(" ");
    }

    public List<List<String>> getbridge() {
        return bridge;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
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

    public boolean getSuccess() {
        return success;
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
