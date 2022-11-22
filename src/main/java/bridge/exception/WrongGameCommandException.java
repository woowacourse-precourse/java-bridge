package bridge.exception;

import static bridge.constant.ErrorMessage.WRONG_GAME_COMMAND;

public class WrongGameCommandException extends BaseException {

    public WrongGameCommandException() {
        super(WRONG_GAME_COMMAND);
    }
}
