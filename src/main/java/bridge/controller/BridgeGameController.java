package bridge.controller;

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
        insertBridgeSize();
    }

    private void insertBridgeSize() {
        try {
            String bridgeSize = inputView.readBridgeSize();
            bridgeGame.createBridge(new BridgeSize(bridgeSize));
        } catch (IllegalArgumentException ie) {
            OutputView.printErrorMessage(ie.getMessage());
            insertBridgeSize();
        }
    }

    private void startGame() {
        outputView.printStartMessage();
    }
}
