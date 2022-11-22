package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int INIT_TRY_COUNT = 1;
    private List<String> choices;
    private int tryCount;

    public Player() {
        this.choices = new ArrayList<>();
        tryCount = INIT_TRY_COUNT;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void addChoice(final String choice) {
        this.choices.add(choice);
    }

    public void resetChoices() {
        choices.clear();
    }

    public int getStep() {
        return choices.size() - 1;
    }

    public int getChoicesSize() {
        return choices.size();
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addTryCount() {
        tryCount++;
    }
}
