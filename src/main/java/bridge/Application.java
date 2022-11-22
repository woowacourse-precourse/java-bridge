package bridge;

import bridge.engine.BridgeGame;
import bridge.engine.BridgeGameContext;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameContext context = new BridgeGameContext(bridgeGame);

        context.run();
    }
}
