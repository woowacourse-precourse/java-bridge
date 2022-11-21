package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController.initBridgeSize();
        BridgeController.makeBridge();
        BridgeController.initMoveRow();
        BridgeController.compareMove();
    }
}
