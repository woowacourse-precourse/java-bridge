package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void run() {
        startGame();
        BridgeSize bridgeSize = insertBridgeSize();
        Bridge bridge = createBridge(bridgeSize);
    }

    private Bridge createBridge(BridgeSize bridgeSize) {
        Bridge bridge = null;
        try {
            bridge = bridgeGame.createBridge(bridgeSize);
        } catch (IllegalArgumentException ie) {
            OutputView.printErrorMessage(ie.getMessage());
            createBridge(bridgeSize);
        }
        return bridge;
    }

    private BridgeSize insertBridgeSize() {
        BridgeSize bridgeSize = null;
        try {
            String size = inputView.readBridgeSize();
            bridgeSize = new BridgeSize(size);
        } catch (IllegalArgumentException ie) {
            OutputView.printErrorMessage(ie.getMessage());
            insertBridgeSize();
        }
        return bridgeSize;
    }

    private void startGame() {
        outputView.printStartMessage();
    }
}
