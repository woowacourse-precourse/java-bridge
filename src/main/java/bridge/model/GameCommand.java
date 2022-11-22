package bridge.model;

import bridge.util.BridgeGameExceptionMessage;
import java.util.Arrays;

public enum GameCommand {
    RESTART("R"), QUIT("Q");
    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand fromInput(String gameCommand) {
        return Arrays.stream(values())
                .filter(command -> command.getCommand().equals(gameCommand))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(BridgeGameExceptionMessage.COMMAND_NOT_MATCH.getMessage()));
    }

    public String getCommand() {
        return command;
    }
}
