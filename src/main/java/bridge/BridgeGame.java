package bridge;

import java.util.List;

import static bridge.Moving.UP;
import static bridge.Result.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int tryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move(int index, String moving) {
        if (bridge.get(index) == moving) {
            if (bridge.get(index) == UP.getMoving()) {
                return UP_SUCCESS;
            }
            return DOWN_SUCCESS;
        }
        if (bridge.get(index) == UP.getMoving()) {
            return UP_FAIL;
        }
        return DOWN_FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount += 1;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isWrongApproach(Result result) {
        if (result == DOWN_FAIL || result == UP_FAIL) {
            return true;
        }
        return false;
    }
}
