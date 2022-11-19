package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void gameStart() {
        outputView.printIntroMessage();

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
