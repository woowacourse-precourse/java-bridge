package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int indexOfBridge;
    private List<Command> bridgeResult;

    public BridgeGame() {
        this.indexOfBridge = 0;
        this.bridgeResult = new ArrayList<>();
    }

    public int getIndexOfBridge() {
        return indexOfBridge;
    }

    public List<Command> getBridgeResult() {
        return Collections.unmodifiableList(bridgeResult);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move(List<String> bridge, Command direction) {
        final boolean canMove = bridge.get(this.indexOfBridge).equals(direction.getString());
        bridgeResult.add(direction);
        this.indexOfBridge++;

        return getResultOfMove(bridge, canMove);
    }

    private Result getResultOfMove(List<String> bridge, boolean canMove) {
        if (canMove) {
            if (bridge.size() == indexOfBridge) {
                return Result.ARRIVED;
            }
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.indexOfBridge = 0;
        this.bridgeResult.clear();
    }
}
