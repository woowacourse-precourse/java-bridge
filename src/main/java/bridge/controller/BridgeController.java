package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.bridge.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    public void start() {
        OutputView.startBridgeGame();
        BridgeGame bridgeGame = new BridgeGame(initBridge());
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    private Bridge initBridge() {
        try {
            OutputView.enterBridgeSize();
            int size = InputView.readBridgeSize();
            return new Bridge(size);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return initBridge();
        }
    }
}
