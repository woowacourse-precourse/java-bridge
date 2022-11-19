package bridge.inputView.exception;

import bridge.common.ErrorMessage;

public class IllegalReadGameCommandException extends IllegalArgumentException {
    private static final String MESSAGE = ErrorMessage.ILLEGAL_READ_GAME_COMMAND.getTagMessage();

    public IllegalReadGameCommandException() {
        super(MESSAGE);
    }
}
