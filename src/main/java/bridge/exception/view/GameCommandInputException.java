package bridge.exception.view;

import bridge.exception.BridgeException;

public class GameCommandInputException extends BridgeException {
    private static final String COMMAND_DELIMITER = " 또는 ";
    private static final String MOVE_INPUT_EXCEPTION_MESSAGE = "게임 커맨드는 %s 입니다.";

    public GameCommandInputException(String... gameCommand) {
        super(String.format(MOVE_INPUT_EXCEPTION_MESSAGE, String.join(COMMAND_DELIMITER, gameCommand)));
    }
}
