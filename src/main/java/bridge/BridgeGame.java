package bridge;

import bridge.view.InputView;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridge = buildBridge(bridgeNumberGenerator);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        validateUserInputToMove(input);
        bridge.move(input);
    }

    private void validateUserInputToMove(String input) {
        if (Direction.DOWN.isWrong(input)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridge.restart();
    }

    private Bridge buildBridge(BridgeNumberGenerator bridgeNumberGenerator) {
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean isFinish() {
        return bridge.isArrive();
    }

}
