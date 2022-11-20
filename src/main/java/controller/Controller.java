package controller;

import bridge.Bridge;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Bridge bridge = createBridge();
    }

    private Bridge createBridge() {
        BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
