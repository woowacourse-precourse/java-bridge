package bridge.domain.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MoveCommands {

    MOVE_UP_COMMAND("U"),
    MOVE_DOWN_COMMAND("D"),
    ;

    private static final Map<String, MoveCommands> MOVE_COMMANDS = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(
                    moveCommands -> moveCommands.command, Function.identity()));

    private final String command;

    MoveCommands(String command) {
        this.command = command;
    }

    public static MoveCommands of(final String command) {
        if (!MOVE_COMMANDS.containsKey(command)) {
            throw new IllegalArgumentException("U 또는 D만 입력해 주세요. (U:위, D:아래)");
        }
        return MOVE_COMMANDS.get(command);
    }

    public boolean is(final String command) {
        return this.command.equals(command);
    }

    public boolean is(final MoveCommands moveCommands) {
        return this == moveCommands;
    }
}
