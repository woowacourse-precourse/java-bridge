package bridge.domain.enums;

import bridge.constants.ErrorMessages;
import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q"),
    UNKNOWN("");

    private final String command;

    private GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String input) {
        GameCommand gameCommand = Arrays.stream(GameCommand.values())
                .filter(command -> command.getCommand().equals(input))
                .findAny()
                .orElse(UNKNOWN);
        if (gameCommand == UNKNOWN) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_GAME_COMMAND);
        }
        return gameCommand;
    }

    public String getCommand() {
        return command;
    }
}
