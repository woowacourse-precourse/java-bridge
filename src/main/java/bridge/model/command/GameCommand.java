package bridge.model.command;

import bridge.util.ExceptionMessage;
import java.util.Arrays;

public enum GameCommand {

    RETRY("R"), QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand from(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND.getMessage()));
    }
}
