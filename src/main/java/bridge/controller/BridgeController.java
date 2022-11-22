package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    public void startGame() {
        List<String> bridge = generateBridge();
    }

    private List<String> generateBridge() {
        OutputView.printGameStart();
        int size = InputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        return bridgeMaker.makeBridge(size);
    }
}