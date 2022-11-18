package bridge.domain;

import java.util.List;

public class Bridge {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BRIDGE_COMPONENTS_INVALID_ERROR = "다리의 구성 요소가 올바르지 않습니다.";
    private final List<String> directions;
//    private final int size;

    public Bridge(List<String> directions) {
        validate(directions);
        this.directions = directions;
//        this.size = elements.size();
    }

    private void validate(List<String> directions) {
        checkComponent(directions);
    }

    // Bridge (정답) 과 input 을 비교해 O 또는 X 를 반환
    public String compare(Position position) {
        if (directions.get(position.getDistance()).equals(position.getDirection())) {
            return "O";
        }
        return "X";
    }

    private void checkComponent(List<String> directions) {
        boolean isValid = directions.stream()
                .filter(direction -> direction.equals(UP) || direction.equals(DOWN))
                .count() == directions.size();
        if (!isValid) {
            throw new IllegalArgumentException(BRIDGE_COMPONENTS_INVALID_ERROR); // TODO: exception 타입
        }
    }

    public List<String> getDirections() {
        return directions;
    }
}
