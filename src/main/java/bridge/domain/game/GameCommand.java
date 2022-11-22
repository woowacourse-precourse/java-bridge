package bridge.domain.game;

import bridge.utils.game.GameStatus;
import bridge.utils.message.ExceptionMessageUtils;
import java.util.Arrays;

public enum GameCommand {
    RETRY("Q", GameStatus.GAME_EXIT),
    EXIT("R", GameStatus.GAME_PLAY);

    private final String command;
    private final GameStatus gameStatus;

    GameCommand(String command, GameStatus gameStatus) {
        this.command = command;
        this.gameStatus = gameStatus;
    }

    public static GameStatus findNextGameOver(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command.equals(command))
                .map(gameCommand -> gameCommand.gameStatus)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessageUtils
                        .WRONG_GAME_COMMAND.getMessage()));
    }
}
