package bridge;

import bridge.controller.GameController;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Game {
    private final GameController gameController;

    public Game() {
        BridgeGame bridgeGame = new BridgeGame();
        this.gameController = new GameController(bridgeGame);
    }

    public void run() {
        gameController.startGame();
        gameController.playGame();
        gameController.endGame();
    }
}
