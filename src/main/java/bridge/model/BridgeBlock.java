package bridge.model;

import java.util.Objects;

public class BridgeBlock {

    private final Direction direction;
    private final int position;

    public BridgeBlock(Direction direction, int position) {
        this.direction = direction;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BridgeBlock that = (BridgeBlock) o;
        return position == that.position && direction == that.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, position);
    }

    public Direction getDirection() {
        return direction;
    }
}
