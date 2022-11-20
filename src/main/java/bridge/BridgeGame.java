package bridge;

import java.util.List;

public class BridgeGame {

    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public Boolean move(String inputMoving, String nextBridge) {
        return nextBridge.equals(inputMoving);
    }

    public Boolean retry(String retryInput) {
        return retryInput.equals("R");
    }
}
