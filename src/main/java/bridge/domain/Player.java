package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.constant.Direction;

public class Player {

    private final Bridge bridge;
    // private Position position;

    private final List<Direction> directions = new ArrayList<>();

    public Player(Bridge bridge) {
        this.bridge = bridge;
        // this.position = new Position();
    }

    public boolean moveNext(Direction direction) {
        directions.add(direction);
        return bridge.matchesFromStartWith(Bridge.fromDirections(directions));

        // if (bridge.isMovable(position, direction)) {
        //     increasePosition();
        //     return true;
        // }
        // return false;
    }

    // private void increasePosition() {
    //     position = position.increase();
    // }

    public boolean isArrived() {
        return bridge.hasSameSizeWith(Bridge.fromDirections(directions));
        // return bridge.isOver(position);
    }
}
