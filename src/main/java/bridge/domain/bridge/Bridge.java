package bridge.domain.bridge;

import bridge.domain.direction.Direction;

import java.util.List;

public class Bridge {

    private final List<Direction> bridge;

    public Bridge(List<Direction> bridge) {
        this.bridge = bridge;
    }

    public boolean hasElementOf(Direction direction, int location) {
        validateIndexValue(location);
        return direction.equals(bridge.get(location));
    }

    private void validateIndexValue(int location) {
        if (location >= bridge.size() || location < 0) {
            throw new IndexOutOfBoundsException("[ERROR] 다리의 길이를 벗어난 위치 값이 입력되었습니다.");
        }
    }

    public boolean isEnd(int location) {
        return bridge.size() == location;
    }
}
