package bridge.domain;

import bridge.BridgeGame;
import bridge.utils.validator.GameCommandValidator;

public class GameCommand {

    private static final String RESTART = "R";

    private final boolean gameCommand;

    public GameCommand(String gameCommand) {
        new GameCommandValidator(gameCommand);
        this.gameCommand = isRetry(gameCommand);
    }

    private boolean isRetry(String gameCommand) {
        if (gameCommand.equals(RESTART)) {
            return true;
        }
        return false;
    }

    public void isRetryGame(BridgeGame bridgeGame) {
        if (this.gameCommand) {
            bridgeGame.retry();
        }
        if (!this.gameCommand) {
            bridgeGame.exit();
        }
    }

}
