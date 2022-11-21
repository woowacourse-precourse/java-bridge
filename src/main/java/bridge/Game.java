package bridge;

import bridge.controller.GameController;
import bridge.service.BridgeGame;

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
