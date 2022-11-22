package bridge.domain;

import java.util.List;

import static bridge.util.BridgeUtil.GAP_IN_INDEX_AND_SIZE;

public class Player {

    private final List<String> choice;

    public Player(List<String> choice) {
        this.choice = choice;
    }

    public int getNumberOfChoice() {
        return choice.size();
    }

    public void addChoice(String bridgeChoice) {
        choice.add(bridgeChoice);
    }

    public String getChoiceIndex(int index) {
        return choice.get(index);
    }

    public String getLastChoice() {
        return choice.get(getNumberOfChoice() - GAP_IN_INDEX_AND_SIZE);
    }

}
