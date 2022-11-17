package bridge.system.controller;

import bridge.system.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void doGame() {
        outputView.printGameStartMessage();

        outputView.printAskingBridgeSizeMessage();
        int bridgeSize = inputView.readBridgeSize();

        bridgeMaker.makeBridge(bridgeSize);
    }
}
