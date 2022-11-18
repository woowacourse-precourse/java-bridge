package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> choices;
    private int totalTryCount;
    private boolean doesSuccess;

    public User() {
        this.choices = new ArrayList<>();
        totalTryCount = 1;
        doesSuccess = false;
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

    public void doSuccess() {
        this.doesSuccess = true;
    }

    public boolean getDoesSuccess() {
        return doesSuccess;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public String getLastChoice() {
        return choices.get(choices.size() - 1);
    }
}
