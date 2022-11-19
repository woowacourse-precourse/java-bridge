package bridge;

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
            upBridge.add("O");
        }
        if (Direction.isDown(direction)) {
            upBridge.add("X");
        }
        return upBridge;
    }

    public List<String> moveDownBridge(Direction direction) {
        if (Direction.isUp(direction)) {
            downBridge.add("X");
        }
        if (Direction.isDown(direction)) {
            downBridge.add("O");
        }
        return downBridge;
    }

    public void addBlank(Direction now) {
        if (Direction.isUp(now)) {
            downBridge.add(" ");
        }
        if (Direction.isDown(now)) {
            upBridge.add(" ");
        }

    }
}
