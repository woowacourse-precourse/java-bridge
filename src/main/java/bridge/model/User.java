package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> choices;

    public User() {
        this.choices = new ArrayList<>();
    }

    public void addChoice(final String choice) {
        this.choices.add(choice);
    }

    public List<String> getChoices() {
        return choices;
    }
}
