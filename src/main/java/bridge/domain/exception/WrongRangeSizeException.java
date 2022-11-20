package bridge.domain.exception;

import bridge.utils.Constants;

public class WrongRangeSizeException extends IllegalArgumentException {

    public WrongRangeSizeException() {
        super(Constants.WRONG_RANGE_MESSAGE);
    }
}
