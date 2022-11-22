package bridge.exception.view;

import bridge.exception.BridgeException;

public class MoveInputException extends BridgeException {
    private static final String COMMAND_DELIMITER = " 또는 ";
    private static final String MOVE_INPUT_EXCEPTION_MESSAGE = "이동은 %s로 이동 할 수 있습니다.";

    public MoveInputException(String... moveCommand) {
        super(String.format(MOVE_INPUT_EXCEPTION_MESSAGE, String.join(COMMAND_DELIMITER, moveCommand)));
    }
}
