package bridge.exception.domain;

import bridge.exception.BridgeException;

public class BridgeShapeNumberException extends BridgeException {
    private static final String BRIDGE_SHAPE_RANGE_EXCEPTION = "건널 수 있는 칸은 %s인 경우 아래 칸, %s인 경우 위 칸입니다.";

    public BridgeShapeNumberException(int down, int up) {
        super(String.format(BRIDGE_SHAPE_RANGE_EXCEPTION, down, up));
    }
}
