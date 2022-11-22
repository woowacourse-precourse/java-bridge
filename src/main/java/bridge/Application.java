package bridge;

import bridge.controller.BridgeController;
import bridge.game.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = getInitializedGame();
        bridgeGame.run();
    }

    private static BridgeGame getInitializedGame() {
        BridgeController bridgeController = new BridgeController();
        return new BridgeGame(bridgeController, new BridgeRandomNumberGenerator());
    }
}
