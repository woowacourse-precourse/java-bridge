package bridge.exception.domain;

import bridge.exception.BridgeException;

public class CanNotMoveException extends BridgeException {
    private static final String CAN_NOT_MOVE_EXCEPTION_MESSAGE = "더이상 이동할 수 없습니다.";

    public CanNotMoveException() {
        super(CAN_NOT_MOVE_EXCEPTION_MESSAGE);
    }
}
