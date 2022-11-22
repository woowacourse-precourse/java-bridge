package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum FailMenuCommandType {

    RETRY("R", "재시작"),
    QUIT("Q", "종료");

    private final String input;
    private final String name;

    FailMenuCommandType(String input, String name) {
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

    private static final Map<String, FailMenuCommandType> commands =
            Arrays.stream(FailMenuCommandType.values())
                    .collect(Collectors.toUnmodifiableMap(FailMenuCommandType::getInput, Function.identity()));

    public static FailMenuCommandType find(String input) {
        return commands.get(input);
    }
}
