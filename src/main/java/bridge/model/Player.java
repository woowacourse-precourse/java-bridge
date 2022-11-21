package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> choices;
    private int totalTryCount;
    private boolean isSuccess;

    public Player() {
        this.choices = new ArrayList<>();
        totalTryCount = 1;
        isSuccess = false;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void addChoice(final String choice) {
        this.choices.add(choice);
    }

    public List<String> getChoices() {
        return choices;
    }

    public void resetChoices() {
        choices.clear();
    }

    public void addTryCount() {
        totalTryCount++;
    }

    public int getStep() {
        return choices.size() - 1;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public int getChoicesSize() {
        return choices.size();
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
