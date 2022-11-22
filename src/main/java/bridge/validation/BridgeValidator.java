package bridge.validation;

import java.util.List;

public class BridgeValidator {
    private static final List<String> directions = List.of("U", "D");

    private static final String DIRECTION_ERROR_MESSAGE = "U, D 이외의 방향을 가질 수 없습니다.";
    private static final String POSITION_ERROR_MESSAGE = "사용자 위치가, 다리의 길이보다 클 수 없습니다.";

    public static void checkStep(List<String> bridge) {
        bridge.stream()
                .filter(direction -> isWrongMoving(direction))
                .forEach(direction -> {
                    throw new IllegalArgumentException(DIRECTION_ERROR_MESSAGE);
                });
    }

    private static boolean isWrongMoving(String direction) {
        return !directions.contains(direction);
    }

    public static void checkPosition(int position, int size) {
        if (isWrongSize(position, size)) {
            throw new IllegalArgumentException(POSITION_ERROR_MESSAGE);
        }
    }

    private static boolean isWrongSize(int position, int size) {
        return position > size - 1;
    }
}
