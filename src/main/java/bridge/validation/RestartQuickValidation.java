package bridge.validation;

import bridge.util.message.ErrorMessage;

public class RestartQuickValidation implements Validation {
    private static final String RESTART = "R";
    private static final String QUICK = "Q";

    @Override
    public void validate(String value) {
        isUpOrDown(value);
    }

    private void isUpOrDown(String move) {
        if (!(move.equals(RESTART) || move.equals(QUICK))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RESTART_QUICK_VALID_STRING.getMessage());
        }
    }
}
