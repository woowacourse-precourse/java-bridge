package bridge;

import java.util.List;

public class BridgeGame {

    private final List<String> correctBridge;
    private List<String> upperBridge;
    private List<String> bottomBridge;

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
    }

    public Boolean move(String inputMoving, String nextBridge) {
        if (nextBridge.equals(inputMoving)) {

            return true;
        }
        return false;
    }

    public Boolean retry(String retryInput) {
        return retryInput.equals("R");
    }

    private void makeBridgeState(String nextBridge) {

    }

    private Boolean checkUpperBridge(String nextBridge) {
        return nextBridge.equals("U");
    }
}
