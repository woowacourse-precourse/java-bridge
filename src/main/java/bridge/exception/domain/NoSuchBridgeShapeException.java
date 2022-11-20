package bridge.exception.domain;

import bridge.exception.BridgeException;

public class NoSuchBridgeShapeException extends BridgeException {
    private static final String NO_SUCH_BRIDGE_SHAPE_EXCEPTION_MESSAGE = "%s에 해당하는 BridgeShape 가 존재하지 않습니다.";

    public NoSuchBridgeShapeException(String shape) {
        super(String.format(NO_SUCH_BRIDGE_SHAPE_EXCEPTION_MESSAGE, shape));
    }
}
