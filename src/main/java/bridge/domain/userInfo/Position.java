package bridge.domain.userInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Position {

    private final Map<Integer, Direction> position = new HashMap<>();
    private final int distance;

    public Position(int distance, Direction answer) {
        this.distance = distance;
        position.put(distance, answer);
    }

    public Direction getDirection() { // TODO: getter 사용 자제... 메시지를 보내기
        return position.get(distance);
    }

    public boolean compareDirection(List<Direction> directions) {
        return directions.get(distance)
                .isSameDirection(position.get(distance));
    }
}
