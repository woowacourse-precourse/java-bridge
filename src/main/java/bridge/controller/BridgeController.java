package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.model.BridgeManager;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeManager bridgeManager;


    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGreeting() {
        outputView.printGreeting();
    }

    public void setupGame(BridgeNumberGenerator bridgeNumberGenerator) {
        int size = inputView.readBridgeSize();
        bridgeManager = new BridgeManager(bridgeNumberGenerator);
        bridgeManager.setBridgeWithSize(size);
    }

    public void getNowGameCondition() {

    }

    public void moveOneStep() {

    }

    public void figureOutToRestartGame() {

    }

    public void showResult() {

    }
}
