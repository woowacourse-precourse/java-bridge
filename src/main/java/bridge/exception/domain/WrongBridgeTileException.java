package bridge.exception.domain;

import bridge.utils.message.ExceptionMessageUtils;

public class WrongBridgeTileException extends RuntimeException {

    public WrongBridgeTileException() {
        super(ExceptionMessageUtils.WRONG_BRIDGE_TILE.getMessage());
    }
}
