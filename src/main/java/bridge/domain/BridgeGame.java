package bridge.domain;

import bridge.domain.Bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private int position;
    private int attempts;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.position = 0;
        this.attempts = 1;
    }

    public int move() {
        if (position == bridge.getMovableBlocks().size() - 1) {
            return this.position + 1;
        }
        this.position++;
        return this.position;
    }

    public void retry() {
        this.position = 0;
        this.attempts++;
    }

    public boolean isMovable(String movingInput) {
        return this.bridge.isMovableBlock(this.position, movingInput);
    }

    public Bridge getBridge() {
        return this.bridge;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public int getPosition() {
        return this.position;
    }
}
