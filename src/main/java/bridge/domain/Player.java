package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> choice;

    public Player() {
        this.choice = new ArrayList<>();
    }

    public int getNumberOfChoice() {
        return choice.size();
    }

    public void addChoice(String bridgeChoice) {
        choice.add(bridgeChoice);
    }

}
