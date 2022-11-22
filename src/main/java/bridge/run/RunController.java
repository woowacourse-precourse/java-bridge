package bridge.run;

import bridge.bridge.Bridge;
import bridge.bridge.BridgeController;
import bridge.config.BridgeStatus;
import bridge.config.RunStatus;
import bridge.game.Game;
import bridge.game.GameController;

import java.util.ArrayList;
import java.util.List;

import static bridge.config.RunStatus.ON;

public class RunController {

    private final BridgeController bridgeController;
    private final GameController gameController;

    private Bridge bridge;
    private Game game;
    private boolean status;
    private boolean finish;

    public RunController(BridgeController bridgeController, GameController gameController) {
        this.bridgeController = bridgeController;
        this.gameController = gameController;
    }

    public void run() {
        game = gameController.runGame();
        bridge = bridgeController.createBridge();
        while (game.getRunStatus() == ON) {
            finish = gameController.moveBridge(bridge).getResult().equals("X");
            gameController.printResultMap(bridge);
            gameController.checkSuccess(game, bridge);
            if (finish) {
                gameController.retryGame();
            }
        }
    }

}
