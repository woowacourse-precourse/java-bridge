package bridge.domain.game;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static final String UP_DIRECTION = "U";
    public static final String DOWN_DIRECTION = "D";

    private final List<String> bridge;
    private final GameResultLogger result;
    private int currentTryIndex;
    private boolean isStopped;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.result = new GameResultLogger();
        this.currentTryIndex = 0;
        this.isStopped = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (canMove(direction)) {
            result.logResult(direction, CrossResult.SUCCESS);
            return ;
        }
        result.logResult(direction, CrossResult.FAILURE);
        isStopped = true;
    }

    private boolean canMove(String direction) {
        return bridge.get(currentTryIndex++).equals(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.currentTryIndex = 0;
        this.isStopped = false;
        this.result.reset();
    }

    public boolean isEnd() {
        if (isStopped)
            return false;
        return currentTryIndex == bridge.size();
    }

    public boolean isStopped() {
        return isStopped;
    }

    public GameResultLogger getResult() {
        return result;
    }
}
