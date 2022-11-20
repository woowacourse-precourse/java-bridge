package bridge;

import bridge.controller.GameManager;

public class AppConfig {

    public GameManager gameManager(){
        return new GameManager(bridgeGame());
    }

    public BridgeGame bridgeGame() {
        return new BridgeGame();
    }
}
