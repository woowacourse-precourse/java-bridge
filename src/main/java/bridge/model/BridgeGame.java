package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int nowPosition;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }
    public void move() {
    }
    public void retry() {
    }
    public int getNowPosition() {
        return nowPosition;
    }
    public List<String> getBridge() {
        return bridge;
    }
}
