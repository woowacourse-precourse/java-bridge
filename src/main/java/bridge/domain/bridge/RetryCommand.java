package bridge.domain.bridge;

import java.util.Arrays;

public enum RetryCommand {
    Q(0), R(1);

    public static final String ERROR_NOT_FOUND_COMMAND_VALUE = "[ERROR] R,Q 중 하나만 입력할 수 있습니다.";

    private final int commandNum;

    RetryCommand(int commandNum) {
        this.commandNum = commandNum;
    }

    public static RetryCommand convertTypeCommand(String readLine) {
        return Arrays.stream(RetryCommand.values())
                .filter(command -> command.name().equals(readLine))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_COMMAND_VALUE));
    }
}
