package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isEqualByIndex(String playerChoice, int index) {
        return playerChoice.equals(bridge.get(index));
    }

    public boolean isEqual(List<String> playerChoices) {
        return playerChoices.equals(bridge);
    }
}
