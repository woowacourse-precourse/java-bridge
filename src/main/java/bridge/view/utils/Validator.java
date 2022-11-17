package bridge.view.utils;

import static bridge.constant.Constants.*;

public class Validator {

    public static void validateForRangeException(int input) {
        if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

}
