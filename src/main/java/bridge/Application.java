package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    private final static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    public static void main(String[] args) {
        final BridgeGameController bridgeGameController = createBridgeGameController();
        
        bridgeGameController.initializeGame();
        bridgeGameController.playGame();
        bridgeGameController.terminateGame();
    }

    private static BridgeGameController createBridgeGameController() {
        return new BridgeGameController(bridgeNumberGenerator);
    }
}
