package bridge.model;

import static bridge.exception.MovingException.validate;

import java.util.List;

public class BridgeResult {

    public List<Boolean> result;

    public void add(Bridge bridge, String moving) {
        validate(moving);
        result.add(bridge.isRightMoving(result.size(), moving));
    }
}
