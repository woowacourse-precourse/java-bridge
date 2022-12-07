package bridge.domain;

public class BridgeMoving {
    private final Bridge bridge;
    private final BridgeSize bridgeSize;
    private final BridgeIndex bridgeIndex;

    public BridgeMoving(Bridge bridge, BridgeSize bridgeSize, BridgeIndex bridgeIndex) {
        this.bridge = bridge;
        this.bridgeSize = bridgeSize;
        this.bridgeIndex = bridgeIndex;
    }

    public MovingResult move(Direction direction) {
        MovingResult movingResult = getMovingResult(direction);
        bridgeIndex.increase();
        return movingResult;
    }

    private MovingResult getMovingResult(Direction direction) {
        return MovingResult.of(isMove(direction));
    }

    private boolean isMove (Direction direction) {
        return bridge.isMove(bridgeIndex, direction);
    }

    public boolean isComplete() {
        return bridgeIndex.isGreaterThan(bridgeSize);
    }

    public void reset() {
        bridgeIndex.reset();
    }
}
