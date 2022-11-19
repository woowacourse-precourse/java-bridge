package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.CurrentBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int currentSection = 1;
    private static final boolean IS_END = true;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        outputView.printStartGame();
        this.bridge = createBridge();
    }

    public boolean move() {
        String readMoving = inputView.readMoving();
        CurrentBridge currentBridge = new CurrentBridge(bridge.askCurrentShape(currentSection), readMoving);
        currentSection++;
        outputView.printMap(currentBridge);
        if (currentBridge.isFailed() || bridge.getBridgeLength() == currentBridge.getCurrentBridgeLength()) {
            return IS_END;
        }
        return !IS_END;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private Bridge createBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeSize);
    }
}
