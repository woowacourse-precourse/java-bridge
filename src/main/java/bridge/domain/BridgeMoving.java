package bridge.domain;

import bridge.domain.value.BridgeSize;
import bridge.domain.value.MovingShape;

public class BridgeMoving {
    private static final String SUCCESS_MOVING = "O";
    private static final String FAIL_MOVING = "X";
    private final Bridge bridge;
    private final BridgeIndex bridgeIndex;

    public BridgeMoving(Bridge bridge, BridgeIndex bridgeIndex) {
        this.bridge = bridge;
        this.bridgeIndex = bridgeIndex;
    }

    public String move(MovingShape movingShape) {
        String movingResult = getMovingResult(movingShape);
        bridgeIndex.increase();
        return movingResult;
    }

    private String getMovingResult(MovingShape movingShape) {
        if (isMove(movingShape)) {
            return SUCCESS_MOVING;
        }
        return FAIL_MOVING;
    }

    private boolean isMove (MovingShape movingShape) {
        String shape = bridge.getShape(bridgeIndex);
        return movingShape.isEqual(shape);
    }

    public boolean isFail (String shape) {
        return shape.equals(FAIL_MOVING);
    }

    public boolean isComplete() {
        return bridgeIndex.isGreaterThan(bridge.getSize());
    }
}
