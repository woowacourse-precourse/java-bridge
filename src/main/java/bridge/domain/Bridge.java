package bridge.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import bridge.constant.Direction;

public class Bridge {

    private final List<Direction> directions;

    private Bridge(List<Direction> directions) {
        this.directions = directions;
    }

    public static Bridge from(List<String> capitalLetters) {
        return new Bridge(capitalLetters.stream()
                .map(Direction::from)
                .collect(Collectors.toList()));
    }

    static Bridge fromDirections(List<Direction> directions) {
        return new Bridge(directions);
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
