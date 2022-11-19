package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void start() {
        outputView.printStart();

        List<String> bridge = bridgeGame.setBridge(inputBridgeSize().getBridgeSize());
    }

    public BridgeSize inputBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputBridgeSize();
        }
    }
}
