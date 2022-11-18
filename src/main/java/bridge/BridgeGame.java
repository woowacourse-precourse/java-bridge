package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private List<String> userBridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        userBridge = new ArrayList<>();
    }

    public boolean move(String input) {
        userBridge.add(input);

        return (bridge.get(userBridge.size() - 1).equals(input));
    }

    public void retry() {
        userBridge = new ArrayList<>();
    }

    public List<String> getUserBridge() {
        return this.userBridge;
    }

    public boolean compareBridgeLength() {
        return bridge.size() == userBridge.size();
    }
}
