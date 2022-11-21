package bridge.model;

import static bridge.exception.MovingException.validate;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private List<Boolean> result;

    public List<Boolean> getResult() {
        return result;
    }

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

    public boolean getLast() {
        return result.get(result.size() - 1);
    }

    public boolean isEnd(Bridge bridge) {
        return bridge.getSize() == result.size();
    }

    public boolean checkSuccess(Bridge bridge) {
        return isEnd(bridge) && result.get(bridge.getSize() - 1);
    }

    public void initResult() {
        result.clear();
    }
}
