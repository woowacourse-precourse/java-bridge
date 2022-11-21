package bridge.exception;

import static bridge.constant.ErrorMessage.WRONG_BRIDGE_SIZE;

public class WrongBridgeSizeException extends BaseException {

    public WrongBridgeSizeException() {
        super(WRONG_BRIDGE_SIZE);
    }
}
