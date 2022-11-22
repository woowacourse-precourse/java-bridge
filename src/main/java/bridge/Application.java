package bridge;

import bridge.controller.BridgeGameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameManager bridgeGameManager = new BridgeGameManager();
        bridgeGameManager.run();
        bridgeGameManager.printGameResult();
    }
}
