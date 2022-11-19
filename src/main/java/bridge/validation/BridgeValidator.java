package bridge.validation;

import java.util.List;

public class BridgeValidator {

    private static final List<String> directions = List.of("U", "D");

    public static void check(List<String> bridge) {
        bridge.stream()
                .filter(direction -> isWrongMoving(direction))
                .forEach(direction -> {
                    throw new IllegalArgumentException("U, D 이외의 방향을 가질 수 없습니다.");
                });
    }

    private static boolean isWrongMoving(String direction) {
        return !directions.contains(direction);
    }
}
