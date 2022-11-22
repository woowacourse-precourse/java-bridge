package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameSimulation {
    private List<List<String>> bridge;

    private int location;
    private String success;

    public GameSimulation() {
        this.bridge = new ArrayList<>();
        this.location = 0;
        List<String> upside = new ArrayList<>();
        List<String> down = new ArrayList<>();
        bridge.add(upside);
        bridge.add(down);
        this.success = "실패";
    }

    public void print(String userInput, String answer) {
        if (userInput.equals("U")) {
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

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    public void addLocation() {
        this.location += 1;
    }

}
