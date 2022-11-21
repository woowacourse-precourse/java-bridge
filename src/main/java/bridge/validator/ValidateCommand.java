package bridge.validator;

import static bridge.util.BridgeConstant.GAME_QUIT_KEY;
import static bridge.util.BridgeConstant.GAME_RETRY_KEY;

public class ValidateCommand implements Validator {
    private final String INPUT_COMMAND_ERROR_MESSAGE = "R, Q 외의 값을 입력했습니다.";

    @Override
    public void validate(String readGameCommand) {
        if (!validateCommandRange(readGameCommand)) {
            throw new IllegalArgumentException(INPUT_COMMAND_ERROR_MESSAGE);
        }
    }

    private boolean validateCommandRange(String readGameCommand) {
        return readGameCommand.equals(GAME_RETRY_KEY) || readGameCommand.equals(GAME_QUIT_KEY);
    }
}
