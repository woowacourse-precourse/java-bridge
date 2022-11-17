package bridge.run;

import bridge.bridge.BridgeController;
import bridge.game.GameController;

public class RunController {

    private final BridgeController bridgeController;
    private final GameController gameController;

    private boolean status;

    public RunController(BridgeController bridgeController, GameController gameController) {
        this.bridgeController = bridgeController;
        this.gameController = gameController;
    }

    public void run() {

        status = gameController.runGame();

        while (status) {
            bridgeController.createBridge();
            gameController.moveBridge();
            status = gameController.retryGame();
        }

        gameController.printResultMap();
        gameController.printResultAndCount();

    }
}
