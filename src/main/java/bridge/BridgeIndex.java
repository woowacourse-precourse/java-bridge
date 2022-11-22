package bridge;

public class BridgeIndex {

    private int bridgeIndex;

    public BridgeIndex() {
        bridgeIndex = 0;
    }

    public int getBridgeIndex() {
        return bridgeIndex;
    }

    public boolean endGame(int bridgeSize) {
        return bridgeIndex == bridgeSize;
    }

    public void moveForward() {
        bridgeIndex++;
    }
}
