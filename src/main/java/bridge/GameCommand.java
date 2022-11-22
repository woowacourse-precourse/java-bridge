package bridge;

import bridge.validation.exception.InvalidGameCommandException;
import java.util.Arrays;

public enum GameCommand {

    RETRY("R"),
    QUIT("Q");

    private final String mark;

    GameCommand(String mark) {
        this.mark = mark;
    }

    public static GameCommand from(String mark) {
        return Arrays.stream(values())
                .filter(g -> g.mark.equals(mark))
                .findFirst()
                .orElseThrow(InvalidGameCommandException::new);
    }

    public static boolean isRetry(GameCommand userCommand) {
        return userCommand == GameCommand.RETRY;
    }
}
