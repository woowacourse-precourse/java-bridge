package bridge;

import bridge.engine.BridgeGame;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameContext context = new BridgeGameContext(bridgeGame);

        context.run();
    }
}
