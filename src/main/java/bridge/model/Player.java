package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> choices;
    private int tryCount;
    private boolean isSuccess;

    public Player() {
        this.choices = new ArrayList<>();
        tryCount = 1;
        isSuccess = false;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void addChoice(final String choice) {
        this.choices.add(choice);
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void resetChoices() {
        choices.clear();
    }

    public void addTryCount() {
        tryCount++;
    }

    public int getStep() {
        return choices.size() - 1;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getChoicesSize() {
        return choices.size();
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
