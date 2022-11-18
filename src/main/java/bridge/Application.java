package bridge;

import bridge.controller.BridgeController;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController();
        bridgeController.start();
    }
}
