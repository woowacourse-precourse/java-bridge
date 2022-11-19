package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.CurrentBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private final CurrentBridge currentBridge;
    private int currentSection = 1;
    private int trialCount = 0;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        outputView.printStartGame();
        this.bridge = createBridge();
        this.currentBridge = new CurrentBridge();
    }

    public Map<String, Boolean> move() {
        String readMoving = inputView.readMoving();
        currentBridge.setSection(bridge.askCurrentShape(currentSection), readMoving);
        currentSection++;
        outputView.printMap(currentBridge);
        return getGameManager();
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

    private Map<String, Boolean> getGameManager() {
        boolean isSuccessGame = currentBridge.isSuccessLastSection();
        boolean isLastSection = bridge.getBridgeLength() == currentBridge.getCurrentBridgeLength();
        if (!isSuccessGame || isLastSection) {
            trialCount++;
            return Map.of("isGameEnd", true, "isSuccessGame", isSuccessGame);
        }
        return Map.of("isGameEnd", false, "isSuccessGame", false);
    }
}
