package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Game;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        Game game = bridgeGame.start();
        // BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        // bridgeMaker.makeBridge(3);
    }
}
