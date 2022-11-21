package bridge.view;

import bridge.config.ErrorMessageConstant;
import bridge.domain.model.Direction;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandType {
    MOVE_TO_UP("U"),
    MOVE_TO_DOWN("D"),
    GAME_RETRY("R"),
    GAME_QUIT("Q");

    private static final Map<String, String> COMMAND_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(CommandType::getCommand, CommandType::name))
    );

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static CommandType of(final String command) throws IllegalArgumentException {
        String name = COMMAND_MAP.get(command);
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessageConstant.COMMAND_NOT_FOUND);
        }
        return CommandType.valueOf(name);
    }
}
