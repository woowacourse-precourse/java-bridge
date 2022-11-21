package bridge.utils.validator;

import static bridge.utils.Constant.*;

import bridge.utils.Util;

public class BridgeValidator {

    private static final String NOT_INTEGER_STATE = "다리 길이는 숫자로 입력되어야 합니다.";
    private static final String NOT_RANGE_STATE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    protected final String BridgeSize;

    public BridgeValidator(String BridgeSize) {
        this.BridgeSize = BridgeSize;
        isInteger();
        isValidRange();
    }

    private void isInteger() {
        try {
            Util.getInt(BridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_INTEGER_STATE);
        }
    }

    private void isValidRange() {
        if (Util.getInt(BridgeSize) > 20 || Util.getInt(BridgeSize) < 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_RANGE_STATE);
        }
    }

}
