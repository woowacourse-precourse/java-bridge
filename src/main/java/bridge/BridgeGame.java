package bridge;

import bridge.util.Message;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final MoveLog moveLog;
    private int index = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public BridgeGame(List<String> bridge, MoveLog moveLog) {
        this.bridge = bridge;
        this.moveLog = moveLog;
    }

    public void move(String move) {
        if (isMoveStringFalse(move)) {
            throw new IllegalArgumentException(Message.ERROR_MOVE.getMessage());
        }
    }

    public MovingType userMoveToChoice(String userMove, int index) {
        if (bridge.get(index).equals(userMove)) {
            return MovingType.SUCCESS;
        }
        return MovingType.FAIL;
    }

    private boolean isMoveStringFalse(String move) {
        return !(move.equals("U") || move.equals("D"));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}