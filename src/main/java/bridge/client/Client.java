package bridge.client;

import bridge.controller.CreatingController;
import bridge.controller.GameController;
import bridge.model.Bridge;
import bridge.model.BridgeGame;

public class Client {

    public void run() {
        CreatingController creatingController = new CreatingController();

        creatingController.start();
        Bridge bridge = creatingController.createBridge();
        BridgeGame bridgeGame = creatingController.createBridgeGame(bridge);

        GameController gameController = new GameController(bridgeGame);
        gameController.run();
    }
}
