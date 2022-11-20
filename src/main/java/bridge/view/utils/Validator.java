package bridge.view.utils;

import static bridge.constant.Constants.*;

public class Validator {

    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;

    public static void validateForRangeException(int input) {
        if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateForIllegalInputUpOrDown(String input) {
        if (!UP_COMMAND.equals(input) && !DOWN_COMMAND.equals(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_U_OR_D_MESSAGE);
        }
    }

    public static void validateForIllegalInputRestartOrQuit(String input) {
        if (!RESTART_COMMAND.equals(input) && !QUIT_COMMAND.equals(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_ERROR_MESSAGE + SELECT_R_OR_Q_MESSAGE);
        }
    }

}
