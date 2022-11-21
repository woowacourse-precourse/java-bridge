package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String CAN_MOVING = "O";
    private static final String CAN_NOT_MOVING = "X";
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */


    public void move(String crossDirection, String movingInput) {

    }

    private boolean checkCanMoving(String crossDirection, String movingInput) {
        return crossDirection.equals(movingInput);
    }

    private String getMovingResult(String crossDirection, String movingInput) {
        if (checkCanMoving(crossDirection, movingInput)) {
            return CAN_MOVING; // 이동 가능
        }
        return CAN_NOT_MOVING; // 이동 불가능
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
