package bridge;

import bridge.view.OutputView;

public class BridgeApplication {

    private final OutputView outputView;

    public BridgeApplication() {
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
    }
}
