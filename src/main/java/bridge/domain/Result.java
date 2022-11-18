package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<String> up;
    private List<String> down;
    private int numberOfTrial = 0;

    public Result() {
        up = new ArrayList<>();
        down = new ArrayList<>();
    }

    public List<String> getUp() {
        return up;
    }

    public List<String> getDown() {
        return down;
    }

    public void update(String isCorrect, String moveTo) {
        if (moveTo == "U") {
            up.add(isCorrect);
        }
        if (moveTo == "D") {
            down.add(isCorrect);
        }
    }

    public void updateNumberOfTrial() {
        numberOfTrial++;
    }
}
