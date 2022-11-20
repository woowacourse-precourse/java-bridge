package bridge.run;

import bridge.bridge.BridgeController;
import bridge.config.BridgeStatus;
import bridge.game.GameController;

import java.util.ArrayList;
import java.util.List;

public class RunController {

    private final BridgeController bridgeController;
    private final GameController gameController;

    private List<BridgeStatus> bridge = new ArrayList<>();
    private boolean status;

    public RunController(BridgeController bridgeController, GameController gameController) {
        this.bridgeController = bridgeController;
        this.gameController = gameController;
    }

    public void run() {

        status = gameController.runGame();

        while (status) {
            bridge = bridgeController.createBridge();
            gameController.moveBridge();
            status = gameController.retryGame();
        }

        gameController.printResultMap();
        gameController.printResultAndCount();

    }
}
