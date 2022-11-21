package bridge;

import bridge.domain.Bridge;
import bridge.domain.MoveType;
import bridge.domain.result.Result;
import bridge.domain.result.ResultType;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Result result;

    public BridgeGame(Bridge bridge, Result result) {
        this.bridge = bridge;
        this.result = result;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result move(MoveType moveType) {
        ResultType resultType = bridge.move(moveType);

        if (moveType.isSame("U")) {
            result.addUpBlock(resultType);
            return result;
        }
        result.addDownBlock(resultType);
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void createBridge(int size) {
        bridge.create(size);
    }
}
