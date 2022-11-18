package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum FailMenuCommandType {

    RESTART("R"),
    QUIT("Q");

    private static final String COMMAND_NOT_FOUND = Arrays.stream(values())
            .map(FailMenuCommandType::getCommand)
            .collect(Collectors.joining(", ")) +
            " 중 하나를 입력해야 합니다.";

    private final String command;

    FailMenuCommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    private static final Map<String, FailMenuCommandType> commands =
            Arrays.stream(FailMenuCommandType.values())
                    .collect(Collectors.toUnmodifiableMap(FailMenuCommandType::getCommand, Function.identity()));

    public static FailMenuCommandType find(String command) {
        FailMenuCommandType foundCommand = commands.get(command);
        if (foundCommand == null) {
            throw new NullPointerException(COMMAND_NOT_FOUND);
        }
        return foundCommand;
    }
}
