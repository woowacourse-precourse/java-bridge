package bridge.util.validator;

import bridge.engine.BridgeDirection;

import static bridge.util.ErrorLevel.ERROR;
import static bridge.view.ErrorMessage.*;

public class DirectionValidator extends Validator {

    @Override
    public void check(final String input) {
        if (!isAlpha(input)) {
            throw new IllegalArgumentException(ERROR.toMessage() + NOT_ALPHABETIC);
        }

        if (!BridgeDirection.isMatch(input)) {
            throw new IllegalArgumentException(ERROR.toMessage() + INVALID_DIRECTION);
        }
    }
}
