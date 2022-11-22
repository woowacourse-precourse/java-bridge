package bridge.bridgeGame;

import static bridge.exception.IllegalArgumentExceptionMessage.ILLEGAL_GAME_COMMAND;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum GameCommand {
    COMMAND_RETRY("R"), COMMAND_QUIT("Q");

    static final Map<String, GameCommand> mapper = new HashMap<>();

    static {
        Arrays.stream(GameCommand.values())
                .forEach(gameCommand -> mapper.put(gameCommand.getCommandString(), gameCommand));
    }

    final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommandString() {
        return command;
    }

    public static GameCommand fromString(String command) throws IllegalArgumentException {
        if (!mapper.containsKey(command)) {
            throw new IllegalArgumentException(ILLEGAL_GAME_COMMAND.getMessage());
        }
        return mapper.get(command);
    }
}
