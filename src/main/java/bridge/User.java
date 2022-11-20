package bridge;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> pathOfUpperBridge;
    private List<String> pathOfLowerBridge;
    private int round;

    public User() {
        this.pathOfUpperBridge = new ArrayList<>();
        this.pathOfLowerBridge = new ArrayList<>();
        this.round = 0;
    }

    public List<String> getPathOfUpperBridge() {
        return pathOfUpperBridge;
    }

    public List<String> getPathOfLowerBridge() {
        return pathOfLowerBridge;
    }

    public void addPathOfBridge(String direction, String result) {
        if (direction.equals("U")) {
            this.pathOfUpperBridge.add(result);
            this.pathOfLowerBridge.add(" ");
        }
        if (direction.equals("D")) {
            this.pathOfUpperBridge.add(" ");
            this.pathOfLowerBridge.add(result);
        }
    }

    public void plusRound() {
        this.round++;
    }

    public int getRound() {
        return this.round;
    }
}
