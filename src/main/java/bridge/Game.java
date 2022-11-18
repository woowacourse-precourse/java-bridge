package bridge;

import bridge.controller.GameController;
import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Game {

    private static final String THROWABLE_MESSAGE_SYSTEM_ERROR = "[ERROR] 시스템적 문제 발생";
    private final GameController gameController;

    public Game() {
        BridgeGame bridgeGame = new BridgeGame();
        this.gameController = new GameController(bridgeGame);
    }

    public void run() {
        try {
            gameController.startGame();
            gameController.playGame();
            gameController.endGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } catch (Throwable throwable) {
            System.out.println(THROWABLE_MESSAGE_SYSTEM_ERROR);
        }
    }
}
