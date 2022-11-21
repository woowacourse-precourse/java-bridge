package bridge.domain;

import bridge.domain.util.Rules;
import java.util.ArrayList;
import java.util.List;

public class UserBridge {
    private List<String> upBridge;
    private List<String> downBridge;

    public UserBridge() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public List<String> moveUpBridge(Direction direction) {
        if (Direction.isUp(direction)) {
            upBridge.add(Rules.CROSS);
        }
        if (Direction.isDown(direction)) {
            upBridge.add(Rules.CROSS_FAIL);
        }
        return upBridge;
    }

    public List<String> moveDownBridge(Direction direction) {
        if (Direction.isUp(direction)) {
            downBridge.add(Rules.CROSS_FAIL);
        }
        if (Direction.isDown(direction)) {
            downBridge.add(Rules.CROSS);
        }
        return downBridge;
    }

    public void addBlank(Direction now) {
        if (Direction.isUp(now)) {
            downBridge.add(Rules.BLANK);
        }
        if (Direction.isDown(now)) {
            upBridge.add(Rules.BLANK);
        }
    }

    public int size() {
        return upBridge.size();
    }

    public void reset() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }
}
