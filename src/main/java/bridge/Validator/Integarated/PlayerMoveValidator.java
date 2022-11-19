package bridge.Validator.Integarated;

import bridge.Enum.ErrorMessage;
import bridge.Validator.UpDownValidator;

public class PlayerMoveValidator implements UpDownValidator {
    public void validate(final String input) {
        if (!isCorrectMove(input)) {
            throw new IllegalArgumentException(ErrorMessage.UPDWON_INPUT_ERROR.getMessage());
        }
    }
}
