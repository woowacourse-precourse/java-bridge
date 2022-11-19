package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public int size() {
        return upBridge.size();
    }

    public void reset() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserBridge that = (UserBridge) o;
        return Objects.equals(upBridge, that.upBridge) && Objects.equals(downBridge, that.downBridge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upBridge, downBridge);
    }
}
