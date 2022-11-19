package bridge.domain;

import bridge.constant.Direction;

public class Player {

    private final Bridge bridge;
    private Position position;

    public Player(Bridge bridge) {
        this.bridge = bridge;
        this.position = new Position();
    }

    public boolean moveNext(Direction direction) {
        boolean isMovable = bridge.isMovable(position, direction);
        increasePosition();
        return isMovable;
    }

    private void increasePosition() {
        position = position.increase();
    }

    public boolean isArrived() {
        return bridge.isArrived(position);
    }
}
