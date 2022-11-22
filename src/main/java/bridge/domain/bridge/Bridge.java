package bridge.domain.bridge;

import bridge.domain.direction.Direction;

import java.util.List;

public class Bridge {

    public static final int STARTING_POINT = 0;
    private final List<Direction> bridge;

    public Bridge(List<Direction> bridge) {
        this.bridge = bridge;
    }

    public boolean hasElementOf(Direction direction, int location) {
        validateIndexValue(location);
        return direction.equals(bridge.get(location));
    }

    private void validateIndexValue(int location) {
        if (isOutOfBridgeRange(location)) {
            throw new IndexOutOfBoundsException("[ERROR] 다리의 길이를 벗어난 위치 값이 입력되었습니다.");
        }
    }

    private boolean isOutOfBridgeRange(int location) {
        return location >= bridge.size() || location < STARTING_POINT;
    }

    public boolean isEnd(int location) {
        return bridge.size() == location;
    }
}
