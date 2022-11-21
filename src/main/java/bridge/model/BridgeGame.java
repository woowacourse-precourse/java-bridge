package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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
        initializePosition();
        retryCount += 1;
    }

    public void initializePosition() {
        nowPosition = 0;
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
