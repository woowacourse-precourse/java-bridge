package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void run() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
    }
}
