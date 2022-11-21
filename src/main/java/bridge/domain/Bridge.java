package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private static final String UP = "U";
    private static final String DOWN = "D";
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

    // Bridge (정답) 과 input 을 비교해 O 또는 X 를 반환
    public boolean compare(Position position) {
        if (position.canMove(directions)) {
            return true;
        }
        return false;
    }

    private void checkComponent(List<String> directions) {
        boolean isValid = directions.stream()
                .filter(direction -> direction.equals(UP) || direction.equals(DOWN))
                .count() == directions.size();
        if (!isValid) {
            throw new IllegalArgumentException(BRIDGE_COMPONENTS_INVALID_ERROR); // TODO: exception 타입
        }
    }
}
