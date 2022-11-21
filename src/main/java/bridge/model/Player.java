package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> choices;
    private int totalTryCount;

    public Player() {
        this.choices = new ArrayList<>();
        totalTryCount = 1;
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

    public String getLastChoice() {
        return choices.get(choices.size() - 1);
    }
}
