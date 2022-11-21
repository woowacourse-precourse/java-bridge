package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int index = 0;
    private final String NONE = " ";
    private final List<String> bridge;
    private final MoveLog moveLog;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public BridgeGame(List<String> bridge, MoveLog moveLog) {
        this.bridge = bridge;
        this.moveLog = moveLog;
    }

    public MovingType move(String userMove) {
        MovingType movingType = userMoveToChoice(userMove, index);
        if (userMove.equals(BridgeType.UP.getStringCode())) {
            moveLog.updateMoveLog(BridgeType.UP, movingType.getIsSuccess());
            moveLog.updateMoveLog(BridgeType.DOWN, NONE);
        }
        if (userMove.equals(BridgeType.DOWN.getStringCode())) {
            moveLog.updateMoveLog(BridgeType.UP, NONE);
            moveLog.updateMoveLog(BridgeType.DOWN, movingType.getIsSuccess());
        }
        return movingType;
    }

    public MovingType userMoveToChoice(String userMove, int index) {
        if (bridge.get(index).equals(userMove)) {
            this.index += 1;
            return MovingType.SUCCESS;
        }
        this.index += 1;
        return MovingType.FAIL;
    }

    public MoveLog getMoveLog() {
        return this.moveLog;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}