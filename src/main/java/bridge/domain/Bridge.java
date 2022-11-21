package bridge.domain;

import java.util.List;

public class Bridge {

    private static final int POSITION_INIT_NUMBER = 0;

    private final List<String> bridge;
    private int currentPosition = POSITION_INIT_NUMBER;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCurrentBridgeDirection(String direction) {
        return bridge.get(currentPosition).equals(direction);
    }

    public void moveForward() {
        currentPosition++;
    }

    public void init() {
        currentPosition = POSITION_INIT_NUMBER;
    }

    public boolean isCross() {
        return bridge.size() == currentPosition;
    }

}
