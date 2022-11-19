package bridge.domain;

import bridge.constant.Direction;

public class Player {

    private final Bridge bridge;
    private int position;

    public Player(Bridge bridge) {
        this.bridge = bridge;
        this.position = 0;
    }

    public boolean moveNext(Direction direction) {
        boolean isMovable = bridge.isMovable(position, direction);
        position += 1;
        return isMovable;
    }

    public boolean isArrived() {
        if(bridge.isArrived(position)){
            return true;
        }
        return false;
    }
}
