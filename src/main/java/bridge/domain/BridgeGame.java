package bridge.domain;

import static bridge.utils.message.ErrorMessagesUtil.MOVING;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private MoveResult moveResult;
    private List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.moveResult = new MoveResult();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(String moving) {
        validateMoving(moving);

        if (bridge.get(nowIndex()).equals(moving)) {
            return moveSuccess(moving);
        }
        return moveFail(moving);
    }

    private void validateMoving(String moving) {
        if (moving.equals("U") || moving.equals("D")) {
            return;
        }
        throw new IllegalArgumentException(MOVING.getMessage());
    }

    private int nowIndex() {
        return moveResult.getStep();
    }

    private MoveResult moveSuccess(String moving) {
        moveResult.addMove(moving, "O");
        return moveResult;
    }

    private MoveResult moveFail(String moving) {
        moveResult.addMove(moving, "X");
        return moveResult;
    }

    public boolean isFinish() {
        return moveResult.isFinish(bridge.size());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
