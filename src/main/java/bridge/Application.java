package bridge;

import bridge.config.BridgeGameConfig;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = BridgeGameConfig.configureBridgeGame();

        bridgeGame.runGame();
    }
}
