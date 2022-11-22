package bridge.constant;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MoveCommand {
    MOVE_UP_VALUE("U"),
    MOVE_DOWN_VALUE("D");

    private final String command;

    MoveCommand(String command) {
        this.command = command;
    }

    private static final Map<String, MoveCommand> MOVE_VALUE_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(
                    moveCommand -> moveCommand.command,  Function.identity()));

    public static MoveCommand of(final String command) {
        if (!MOVE_VALUE_MAP.containsKey(command)) {
            throw new IllegalArgumentException("U 또는 D만 입력해 주세요. (U:위, D:아래)");
        }
        return MOVE_VALUE_MAP.get(command);
    }
}
