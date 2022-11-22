package bridge.controller;


import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();

    public void run() {
        outputView.printStartMessage();
        List<String> bridge = generateBridge();
    }

    private List<String> generateBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
