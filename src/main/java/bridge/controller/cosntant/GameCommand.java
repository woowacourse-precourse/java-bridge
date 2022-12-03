package bridge.controller.cosntant;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum GameCommand {
    Retry("R", true),
    Quit("Q", false);
    private final String gameCommand;
    private final boolean doRetry;

    GameCommand(String gameCommand, boolean doRetry) {
        this.gameCommand = gameCommand;
        this.doRetry = doRetry;
    }

    private static boolean isSameCommand(GameCommand gameCommand, String userGameCommand) {
        return gameCommand.gameCommand.equals(userGameCommand);
    }

    private static GameCommand findByGameCommand(String userGameCommand) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> GameCommand.isSameCommand(gameCommand, userGameCommand))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public static boolean transformToAction(String userGameCommand) {
        GameCommand gameCommand = GameCommand.findByGameCommand(userGameCommand);
        if (Objects.isNull(gameCommand)) {
            throw new NullPointerException();
        }
        return gameCommand.doRetry;
    }
}
