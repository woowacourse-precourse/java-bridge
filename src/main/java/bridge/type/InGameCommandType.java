package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum InGameCommandType {

    MOVE_UP("U", "위"),
    MOVE_DOWN("D", "아래");

    private final String input;
    private final String name;

    InGameCommandType(String input, String name) {
        this.input = input;
        this.name = name;
    }

    public String getInput() {
        return input;
    }

    public String getName() {
        return name;
    }

    public static String getDescription() {
        return Arrays.stream(values())
                .map(value -> value.getName() + ": " + value.getInput())
                .collect(Collectors.joining(", "));
    }

    private static final Map<String, InGameCommandType> commands =
            Arrays.stream(InGameCommandType.values())
                    .collect(Collectors.toUnmodifiableMap(InGameCommandType::getInput, Function.identity()));

    public static InGameCommandType find(String input) {
        return commands.get(input);
    }
}
