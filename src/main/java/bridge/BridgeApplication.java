package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeApplication {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeApplication() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        try {
            outputView.printStartMessage();
            int bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {

        }
    }
}
