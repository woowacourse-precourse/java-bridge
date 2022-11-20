package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private InputView input;
    private OutputView output;
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private boolean complete;

    public BridgeGameController() {
        initFields();
    }

    private void initBridge() {
        this.output.printInputBridgeSize();
        int size = this.input.readBridgeSize();
        this.bridge = new Bridge(size);
    }

    private void initFields() {
        this.input = new InputView();
        this.output = new OutputView();
        this.output.printGameStart();
        initBridge();
        this.bridgeGame = new BridgeGame(this.bridge.getBridge());
        this.complete = false;
    }
}
