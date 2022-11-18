package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum InGameCommandType {

    UP("U"),
    DOWN("D");

    private static final String COMMAND_NOT_FOUND = Arrays.stream(values())
            .map(InGameCommandType::getCommand)
            .collect(Collectors.joining(", ")) +
            " 중 하나를 입력해야 합니다.";

    private final String command;

    InGameCommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    private static final Map<String, InGameCommandType> commands =
            Arrays.stream(InGameCommandType.values())
                    .collect(Collectors.toUnmodifiableMap(InGameCommandType::getCommand, Function.identity()));

    public static InGameCommandType find(String command) {
        InGameCommandType selectedCommand = commands.get(command);
        if (selectedCommand == null) {
            throw new NullPointerException(COMMAND_NOT_FOUND);
        }
        return selectedCommand;
    }
}
