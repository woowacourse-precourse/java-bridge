package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        System.out.println(bridge);
    }

    public boolean isUserSelectionCorrect(String correctOption, String userSelection) {
        return correctOption.equals(userSelection);
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public String currentBridge(int index) {
        return bridge.get(index);
    }
}
