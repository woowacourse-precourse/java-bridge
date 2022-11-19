package bridge.model;

import static bridge.exception.MovingException.validate;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private List<Boolean> result;

    public BridgeResult() {
        this.result = new ArrayList<>();
    }

    public BridgeResult(List<Boolean> result) {
        this.result = result;
    }

    public void add(Bridge bridge, String moving) {
        validate(moving);
        result.add(bridge.isRightMoving(result.size(), moving));
    }

    public boolean canMove() {
        return result.get(result.size() - 1);
    }

    public int getSize() {
        return result.size();
    }
}
