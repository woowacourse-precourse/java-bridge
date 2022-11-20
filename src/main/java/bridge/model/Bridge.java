package bridge.model;

import java.util.List;
import java.util.Stack;

public class Bridge {
    private final List<Direction> bridge;

    public Bridge(List<Direction> bridge) {
        this.bridge = bridge;
    }

    public boolean canMove(Direction direction, int index) {
        return bridge.get(index) == direction;
    }

    public boolean canMove(Stack movement) {
        return bridge.get(movement.size() - 1) == movement.peek();
    }

    public boolean arriveAtTheEnd(Stack movement) {
        return bridge.size() == movement.size();
    }
}
