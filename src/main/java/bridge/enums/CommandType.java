package bridge.enums;

import java.util.Arrays;

import static bridge.utils.ErrorMessage.*;

public enum CommandType {
    RETRY("R"),
    QUIT("Q");

    private String initial;

    CommandType(String initial) {
        this.initial = initial;
    }

    public static CommandType selectCommandTypeByInitial(String initial) {
        return Arrays.stream(CommandType.values())
                .filter(command -> command.initial.equals(initial))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(GAME_COMMAND_NOT_OPTIONS));
    }

    public String getInitial() {
        return initial;
    }
}
