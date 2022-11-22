package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int inputSize = BridgeController.initBridgeSize();
        BridgeController.makeBridge(inputSize);
        BridgeController.initMoveRow();
        BridgeController.compareMove();
    }
}
