package bridge;

import bridge.bridge.BridgeController;
import bridge.game.GameController;
import bridge.run.RunController;
import bridge.view.SystemView;

public class Application {

    public static void main(String[] args) {

        SystemView systemView = new SystemView();

        BridgeController bridgeController = new BridgeController();
        GameController gameController = new GameController();
        RunController runController = new RunController(bridgeController, gameController);

        try {
            runController.run();
        } catch (IllegalArgumentException e) {
            systemView.printErrorMessage(e.getMessage());
        }

    }
}
