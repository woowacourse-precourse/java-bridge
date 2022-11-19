package bridge;

import bridge.controller.GameController;
import bridge.utils.game.GameStatus;

public final class GameRunner {

    private GameRunner() {
    }

    public static void run(GameStatus gameStatus) {
        GameController controller = new GameController();

        while (gameStatus.isPlayable()) {
            gameStatus = controller.process(gameStatus);
        }
    }
}
