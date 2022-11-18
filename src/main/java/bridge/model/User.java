package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> choices;
    private String doesSuccess;

    public User() {
        this.choices = new ArrayList<>();
        doesSuccess = "실패";
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

    public int getStep() {
        return choices.size() - 1;
    }

    public void doSuccess() {
        this.doesSuccess = "성공";
    }

    public String getDoesSuccess() {
        return doesSuccess;
    }

    public int getTotalTryCount() {
        return choices.size() - 1;
    }
}
