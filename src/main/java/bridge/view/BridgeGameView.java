package bridge.view;

import bridge.model.BridgeSize;

public class BridgeGameView {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int requestNewBridgeSize() {
        outputView.printStartPrompt();
        BridgeSize bridgeSize = inputView.readBridgeSize();

        return bridgeSize.getBridgeSize();
    }
}
