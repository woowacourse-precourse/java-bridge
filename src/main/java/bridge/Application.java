package bridge;

import controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeNumberGenerator);
        bridgeGameController.gameStart();
    }
}
