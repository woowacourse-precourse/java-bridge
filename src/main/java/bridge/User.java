package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.View.Constants.InputConstants.DOWN;
import static bridge.View.Constants.InputConstants.UP;
import static bridge.View.Constants.OutputConstants.*;

public class User {
    private final List<String> pathOfUpperBridge;
    private final List<String> pathOfLowerBridge;
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

    public void addPathOfBridge(String direction, boolean result) {
        String isRight = convertResultToString(result);
        if (direction.equals(UP)) {
            this.pathOfUpperBridge.add(isRight);
            this.pathOfLowerBridge.add(BLANK);
        }
        if (direction.equals(DOWN)) {
            this.pathOfUpperBridge.add(BLANK);
            this.pathOfLowerBridge.add(isRight);
        }
        plusRound();
    }

    public String convertResultToString(boolean result){
        if (result){
            return RIGHT;
        }
        return WRONG;
    }

    public void plusRound() {
        this.round++;
    }

    public int getRound() {
        return this.round;
    }
}
