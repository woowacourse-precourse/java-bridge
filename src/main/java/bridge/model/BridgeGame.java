package bridge.model;

import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private int nowPosition = 0;
    private int retryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }
    public void move() {
        nowPosition += 1;
    }
    public void retry() {
        nowPosition = 0;
        retryCount += 1;
    }

    public void backForResult() {
        nowPosition -= 1;
    }

    public int getNowPosition() {
        return nowPosition;
    }
    public List<String> getBridge() {
        return bridge;
    }
    public int getRetryCount() {
        return retryCount;
    }
}
