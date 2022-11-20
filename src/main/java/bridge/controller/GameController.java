package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(generator);

    public void run() {
        try {
            outputView.startMsg();
            bridgeMaker.makeBridge(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            OutputView.printMsg("[ERROR] " + exception.getMessage());
        }
    }
}
