package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum FailMenuCommandType {

    RESTART("R", "재시작"),
    QUIT("Q", "종료");

    private static final String COMMAND_NOT_FOUND = "[" + getDescription() + "]" +
            " 중 하나를 입력해야 합니다.";

    private final String command;
    private final String name;

    FailMenuCommandType(String command, String name) {
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

    private static final Map<String, FailMenuCommandType> commands =
            Arrays.stream(FailMenuCommandType.values())
                    .collect(Collectors.toUnmodifiableMap(FailMenuCommandType::getCommand, Function.identity()));

    public static FailMenuCommandType find(String command) {
        return commands.get(command);
    }
}
