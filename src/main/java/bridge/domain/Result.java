package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<String> up;
    private List<String> down;
    private int numberOfTrial;
    private boolean isSuccess;

    public Result() {
        up = new ArrayList<>();
        down = new ArrayList<>();
        numberOfTrial = 1;
        isSuccess = false;
    }

    public List<String> getUp() {
        return up;
    }

    public List<String> getDown() {
        return down;
    }

    public void update(String isCorrect, String moveTo) {
        if (moveTo.equals("U")) {
            up.add(isCorrect);
            down.add(" ");
        }
        if (moveTo.equals("D")) {
            down.add(isCorrect);
            up.add(" ");
        }
    }

    public void updateNumberOfTrial() {
        numberOfTrial++;
    }

    public void reInit() {
        up.clear();
        down.clear();
    }

    public void updateIsSuccess() {
        isSuccess = true;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public int getNumberOfTrial() {
        return this.numberOfTrial;
    }
}
