package bridge;

import bridge.controller.BridgeController;
import bridge.view.InputView;
import bridge.view.OutputView;


public class Application {

    public static void main(String[] args) {
        OutputView.printStart();
        int size = InputView.readBridgeSize();
        BridgeController bridgeController = new BridgeController(size);
        bridgeController.start();
    }
}
