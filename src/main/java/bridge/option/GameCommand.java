package bridge.option;

import java.util.Arrays;

public enum GameCommand {
    RESTART("R"),
    END("E"),
    UNKNOWN("");

    private final String keyValue;

    GameCommand(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyValue() {
        return keyValue;
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
