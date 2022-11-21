package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum InGameCommandType {

    MOVE_UP("U", "위"),
    MOVE_DOWN("D", "아래");

    private final String command;
    private final String name;

    InGameCommandType(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public static String getDescription() {
        return Arrays.stream(values())
                .map(value -> value.getName() + ": " + value.getCommand())
                .collect(Collectors.joining(", "));
    }

    private static final Map<String, InGameCommandType> commands =
            Arrays.stream(InGameCommandType.values())
                    .collect(Collectors.toUnmodifiableMap(InGameCommandType::getCommand, Function.identity()));

    public static InGameCommandType find(String command) {
        return commands.get(command);
    }
}
