package bridge;

import java.util.List;

public class BridgeData {
    private final List<String> bridge;
    private int currentPosition;

    public BridgeData(List<String> bridge, int currentPosition) {
        this.bridge = bridge;
        this.currentPosition = currentPosition;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void updatePosition() {
        currentPosition++;
    }

    public void reducePosition() {
        currentPosition--;
    }
}
