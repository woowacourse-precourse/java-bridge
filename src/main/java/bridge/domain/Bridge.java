package bridge.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import bridge.constant.Direction;

public class Bridge {

    private final List<Direction> directions;

    public Bridge(List<String> capitalLetters) {
        this.directions = capitalLetters.stream()
                .map(Direction::from)
                .collect(Collectors.toList());
    }

    public boolean isMovable(Position position, Direction direction) {
        if (isArrived(position)) {
            return false;
        }
        Direction directionOfPosition = directions.get(position.getPosition());
        return Objects.equals(direction, directionOfPosition);
    }

    public boolean isArrived(Position position) {
        return position.isGreaterOrEqualThan(directions.size());
    }
}
