package bridge.domain.enums;

import bridge.constants.ErrorMessages;
import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private final String command;

    private GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String input) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> isSameCommand(gameCommand, input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.INVALID_GAME_COMMAND));
    }

    private static boolean isSameCommand(GameCommand gameCommand, String input) {
        return gameCommand.getCommand().equals(input);
    }

    public String getCommand() {
        return command;
    }
}
