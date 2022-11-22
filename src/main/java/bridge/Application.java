package bridge;

import bridge.domain.BridgeController;
import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController();
        bridgeController.initial();
    }
}
