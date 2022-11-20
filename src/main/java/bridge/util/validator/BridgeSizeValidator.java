package bridge.util.validator;

import static bridge.util.ErrorLevel.ERROR;
import static bridge.view.ErrorMessage.*;

public class BridgeSizeValidator extends Validator {

    @Override
    public void check(final String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ERROR.toMessage() + NOT_NUMERIC);
        }

        int bridgeSize = Integer.parseInt(input);

        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR.toMessage() + INVALID_BRIDGE_SIZE);
        }
    }
}
