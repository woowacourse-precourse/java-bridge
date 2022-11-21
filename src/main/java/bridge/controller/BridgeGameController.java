package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;

    public void start() {
        outputView.printStartGame();
        outputView.printInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
