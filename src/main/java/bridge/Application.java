package bridge;

import bridge.domain.controller.BridgeGameOperator;

public class Application {

    public static void main(String[] args) {
        BridgeGameOperator bridgeGameOperator = new BridgeGameOperator();
        bridgeGameOperator.playBridgeGame();
    }
}
