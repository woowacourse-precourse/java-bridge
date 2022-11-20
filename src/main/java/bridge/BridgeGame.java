package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(generator);
    public void run() {
        try {
            outputView.startMsg();
            int bridgeSize = inputView.readBridgeSize();
            bridgeMaker.makeBridge(bridgeSize);
        } catch (IllegalArgumentException exception) {
            OutputView.printMsg("[ERROR] " + exception.getMessage());
        }
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
}
