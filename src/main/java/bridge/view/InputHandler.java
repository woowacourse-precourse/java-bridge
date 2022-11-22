package bridge.view;

import bridge.domain.constants.ErrorCode;

public class InputHandler {

    public int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw ErrorCode.SIZE_NOT_IN_RANGE.getException();
        }
    }
}
