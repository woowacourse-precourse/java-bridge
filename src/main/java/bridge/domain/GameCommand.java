package bridge.domain;

import java.util.Arrays;

import static bridge.validator.ExceptionMessage.ONLU_RESTART_WHETHER_MESSAGE;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q");

    private String gameCommandString;

    GameCommand(String gameCommandString) {
        this.gameCommandString = gameCommandString;
    }

    public static GameCommand getByCommandString(String gameCommandString) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.gameCommandString.equals(gameCommandString))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ONLU_RESTART_WHETHER_MESSAGE.getMessage()));
    }
}
