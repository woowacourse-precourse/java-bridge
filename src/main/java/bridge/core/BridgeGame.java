package bridge.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private int tryCount = 1;
    private int currentPosition = -1;
    private List<History> moveHistory = new ArrayList<>();

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveDirection) {
        boolean moveSuccess = false;
        if (canMove()) {
            moveSuccess = this.bridge.determineMoveResult(this.currentPosition + 1, moveDirection);
            this.currentPosition++;
            this.moveHistory.add(new History(this.currentPosition, moveDirection, moveSuccess));
        }
        return moveSuccess;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.tryCount++;
        this.currentPosition = -1;
        this.moveHistory.clear();
    }

    public boolean isWin() {
        return isReachedEndOfBridge() && isRecentMoveSucceed();
    }

    private boolean canMove() {
        return !isReachedEndOfBridge()
                && (this.currentPosition == -1 || isRecentMoveSucceed());
    }

    private boolean isRecentMoveSucceed() {
        return this.moveHistory.get(this.currentPosition).isMoveSucess();
    }

    private boolean isReachedEndOfBridge() {
        return this.bridge.isEndOfBridge(this.currentPosition);
    }

    public Bridge getBridge() {
        return this.bridge;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public List<History> getMoveHistory() {
        return this.moveHistory;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
