package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> choices;
    private int totalCount;

    public User() {
        this.choices = new ArrayList<>();
        totalCount = 0;
    }

    public void addChoice(final String choice) {
        this.choices.add(choice);
        totalCount++;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void resetChoices() {
        choices.clear();
        totalCount = 0;
    }

    public int getStep() {
        return choices.size() - 1;
    }
}
