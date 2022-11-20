package bridge;

public class BridgeGame {

    public Boolean move(String inputMoving, String nextBridge) {
        return nextBridge.equals(inputMoving);
    }

    public Boolean retry(String retryInput) {
        return retryInput.equals("R");
    }
}
