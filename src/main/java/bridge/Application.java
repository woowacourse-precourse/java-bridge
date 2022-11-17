package bridge;

import bridge.bridge.BridgeController;
import bridge.game.GameController;
import bridge.run.RunController;

public class Application {

    public static void main(String[] args) {

        BridgeController bridgeController = new BridgeController();
        GameController gameController = new GameController();
        RunController runController = new RunController(bridgeController, gameController);

        runController.run();

    }
}
