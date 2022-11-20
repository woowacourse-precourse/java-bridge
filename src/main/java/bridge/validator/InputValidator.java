package bridge.validator;

import java.util.Set;

public class InputValidator {

    private static final Set<String> MOVING_SET;

    static {
        MOVING_SET = Set.of("D", "U");
    }

    public static void validateMoving(String moving) {
        if (!MOVING_SET.contains(moving)) {
            throw new IllegalArgumentException("[ERROR] 위로 이동하려면 U를, 아래로 이동하려면 D를 입력하세요.");
        }
    }

}
