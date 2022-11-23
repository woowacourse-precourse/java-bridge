package bridge.domain.game;

import static bridge.constant.gameValue.DOWN;
import static bridge.constant.gameValue.UP;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private static final String BRIDGE_COMPONENTS_INVALID_ERROR = "다리의 구성 요소가 올바르지 않습니다.";
    private final List<Direction> directions;

    public Bridge(List<String> directions) {
        validate(directions);
        this.directions = makeDirections(directions);
    }

    private void validate(List<String> directions) {
        checkComponent(directions);
    }

    public List<Direction> makeDirections(List<String> directions) {
        return directions.stream()
                .map(Direction::new)
                .collect(Collectors.toList());
    }

    public boolean canMove(Position position) {
        return position.compareDirection(directions);
    }

    private void checkComponent(List<String> directions) {
        boolean isValid = directions.stream()
                .filter(direction -> direction.equals(UP) || direction.equals(DOWN))
                .count() == directions.size();
        if (!isValid) {
            throw new IllegalStateException(BRIDGE_COMPONENTS_INVALID_ERROR);
        }
    }
}
