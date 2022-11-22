package bridge;

import bridge.controller.BridgeGameManager;
import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();

        BridgeGameManager bridgeGameManager = new BridgeGameManager(bridgeMaker, bridgeGame);

        bridgeGameManager.start();
    }
}
