package bridge.command.enums;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    END("Q"),
    UNKNOWN("");

    private final String keyValue;

    GameCommand(String keyValue) {
        this.keyValue = keyValue;
    }

    public static boolean isInGameCommand(String input) {
        return Arrays.stream(values())
            .anyMatch(gameCommand -> gameCommand.keyValue.equals(input));
    }

    public static GameCommand findGameCommand(String input) {
        return Arrays.stream(values())
            .filter(gameCommand -> gameCommand.keyValue.equals(input))
            .findAny()
            .orElse(UNKNOWN);
    }
}
