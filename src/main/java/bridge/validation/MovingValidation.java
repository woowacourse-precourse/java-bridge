package bridge.validation;

import bridge.util.message.ErrorMessage;

public class MovingValidation implements Validation {
    private static final String UP = "U";
    private static final String DOWN = "D";

    @Override
    public void validate(String value) {
        isUpOrDown(value);
    }

    private void isUpOrDown(String move) {
        if (!(move.equals(UP) || move.equals(DOWN))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVE_VALID_STRING.getMessage());
        }
    }
}
