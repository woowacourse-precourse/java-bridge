package bridge.domain;

import bridge.constant.MovingDirection;
import java.util.ArrayList;
import java.util.List;

public class UserBridge {

    private List<MovingDirection> bridge;

    public UserBridge() {
        this.bridge = new ArrayList<>();
    }

    public void reset() {
        this.bridge = new ArrayList<>();
    }

    public void setMovement(MovingDirection direction) {
        this.bridge.add(direction);
    }

    public MovingDirection getMovingDirection(int currentPosition) {
        return bridge.get(currentPosition);
    }
}
