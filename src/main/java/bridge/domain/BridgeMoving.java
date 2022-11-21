package bridge.domain;

public class BridgeMoving {
    private final Bridge bridge;

    public BridgeMoving(Bridge bridge) {
        this.bridge = bridge;
    }

    public String move(String moving, int movingIndex) {
        if (isMove(moving, movingIndex)) {
            return "O";
        }
        return "X";
    }

    private boolean isMove (String moving, int movingIndex) {
        String shape = bridge.getShape(movingIndex);
        return shape.equals(moving);
    }
}
