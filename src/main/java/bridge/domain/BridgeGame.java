package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.BridgeConstants;
import bridge.constant.ExceptionConstants;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;

    public BridgeGame(int size) {
        isCorrectRange(size);
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void isCorrectRange(int size) {
        if (size < BridgeConstants.MINIMUM_LENGTH || BridgeConstants.MAXIMUM_LENGTH < size) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_RANGE.getMessage());
        }
    }

    private void isCorrectMoving(String moving) {
        if (!List.of(BridgeConstants.DOWN, BridgeConstants.UP).contains(moving)) {
            throw new IllegalArgumentException(ExceptionConstants.INCORRECT_MOVING.getMessage());
        }
    }
}
