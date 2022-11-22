package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int currentUserPosition;
    private boolean gameWinStatus;
    private int totalTryCount;

    BridgeGame(BridgeMaker bridgeMaker, int bridgeSize) {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.currentUserPosition = -1;
        this.gameWinStatus = false;
        this.totalTryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(BridgeBlock block) {
        this.currentUserPosition++;
        if (this.bridge.get(this.currentUserPosition).equals(block.getBridgeBlock())) {
            if (this.currentUserPosition == bridge.size() - 1) {
                this.gameWinStatus = true;
            }
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(RetrySelector retrySelector) {
        if (retrySelector == RetrySelector.RETRY) {
            this.currentUserPosition = -1;
            this.totalTryCount++;
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public int getCurrentUserPosition() {
        return this.currentUserPosition;
    }

    public boolean getGameWinStatus() {
        return this.gameWinStatus;
    }

    public int getTotalTryCount() {
        return this.totalTryCount;
    }
}
