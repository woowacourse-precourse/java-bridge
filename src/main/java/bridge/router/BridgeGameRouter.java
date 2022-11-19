package bridge.router;

import bridge.controller.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameRouter {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameRouter(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void process() {
        initiation();
    }

    private void initiation() {
        outputView.printStartMessage();
        setBridgeSize();
    }

    private void setBridgeSize() {
        outputView.printBridgeSizeInputMessage();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.setBridge(bridgeSize);
    }
}
