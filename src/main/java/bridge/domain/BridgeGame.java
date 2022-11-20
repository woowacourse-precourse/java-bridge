package bridge.domain;

import java.util.List;

import static bridge.domain.Constants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private BridgeState bridgeState;
    private int round;

    public BridgeGame(List<String> bridge, BridgeState bridgeState) {
        this.bridge = bridge;
        this.bridgeState = bridgeState;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String arrow) {
        validateBridgeArrow(arrow);
        round++;
        bridgeState.mark(makeBridgeStatus(arrow));
    }

    private void validateBridgeArrow(String arrow) {
        if (!arrow.equals(UP) && !arrow.equals(DOWN)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isCrossable(String arrow) {
        return arrow.equals(bridge.get(round));
    }

    private BridgeStatus makeBridgeStatus(String arrow) {
        if (isCrossable(arrow)) {
            return BridgeStatus.valueOfArrowAndMark(arrow, O);
        }
        return BridgeStatus.valueOfArrowAndMark(arrow, X);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
