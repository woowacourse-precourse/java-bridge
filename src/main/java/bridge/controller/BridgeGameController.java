package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;


public class BridgeGameController {
    public void run() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        int bridgeSize = bridgeMaker.takeBridgeSize();
    }
}
