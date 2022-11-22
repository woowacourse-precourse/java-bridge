package bridge;

import bridge.controller.BridgeController;

public class Application {
    public static void main(String[] args) {
        // 다리 건너기 게임을 시작한다.
        BridgeController bridgeController = new BridgeController();
        bridgeController.start();
    }
}
