package bridge.domain.game;

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

    public boolean isDirectionUp() {
        return position.get(distance).isSameUp();
    }

    public boolean isDirectionDown() {
        return position.get(distance).isSameDown();
    }

    public boolean compareDirection(List<Direction> directions) {
        return directions.get(distance)
                .isSameDirection(position.get(distance));
    }
}
