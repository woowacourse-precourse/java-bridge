package controller;

import bridge.Bridge;
import bridge.BridgeGame;
import view.InputView;
import view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private int getBridgeSizeFromUser() {
        outputView.printBridgeSizeInputMessage();
        return inputView.readBridgeSize();
    }

    public void start() {
        int bridgeSize = getBridgeSizeFromUser();
        Bridge bridge = bridgeGame.generateBridge(bridgeSize);
    }
}
