package bridge.domain;

import bridge.domain.constant.Constant;
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
            upBridge.add(Constant.CROSS);
        }
        if (Direction.isDown(direction)) {
            upBridge.add(Constant.CROSS_FAIL);
        }
        return upBridge;
    }

    public List<String> moveDownBridge(Direction direction) {
        if (Direction.isUp(direction)) {
            downBridge.add(Constant.CROSS_FAIL);
        }
        if (Direction.isDown(direction)) {
            downBridge.add(Constant.CROSS);
        }
        return downBridge;
    }

    public void addBlank(Direction now) {
        if (Direction.isUp(now)) {
            downBridge.add(Constant.BLANK);
        }
        if (Direction.isDown(now)) {
            upBridge.add(Constant.BLANK);
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
