package bridge.domain.result;

import java.util.Arrays;

public enum RetryCommand {
    Q, R;

    public static final String ERROR_NOT_FOUND_COMMAND_VALUE = "[ERROR] R,Q 중 하나만 입력할 수 있습니다.";

    public static RetryCommand convertTypeCommand(String readLine) {
        return Arrays.stream(RetryCommand.values())
                .filter(command -> command.name().equals(readLine))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FOUND_COMMAND_VALUE));
    }
}
