package bridge.run;

import bridge.bridge.Bridge;
import bridge.bridge.BridgeController;
import bridge.config.BridgeStatus;
import bridge.game.GameController;

import java.util.ArrayList;
import java.util.List;

public class RunController {

    private final BridgeController bridgeController;
    private final GameController gameController;

    private Bridge bridge;
    private boolean status;

    public RunController(BridgeController bridgeController, GameController gameController) {
        this.bridgeController = bridgeController;
        this.gameController = gameController;
    }

    public void run() {
        status = gameController.runGame();
        bridge = bridgeController.createBridge();
        while (status) {
            if (gameController.moveBridge(bridge).getResult().equals("X")) {
                status = gameController.retryGame();
            }
            gameController.printResultMap();
        }
        gameController.printResultAndCount();
    }

}
