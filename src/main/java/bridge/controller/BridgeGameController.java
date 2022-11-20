package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        startGame();
        insertBridgeSize();
    }

    private void insertBridgeSize() {
        try {
            String bridgeSize = inputView.readBridgeSize();
            new BridgeSize(bridgeSize);
        } catch (IllegalArgumentException ie) {
            insertBridgeSize();
        }
    }

    private void startGame() {
        outputView.printStartMessage();
    }
}
