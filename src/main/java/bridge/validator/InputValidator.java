package bridge.validator;

import bridge.domain.BridgeSpec;
import java.util.Set;

public class InputValidator {

    private static final Set<String> MOVING_SET;

    static {
        MOVING_SET = Set.of("D", "U");
    }

    public static void validateBridgeSize(int size) {
        if (size < BridgeSpec.MIN.size() || size > BridgeSpec.MAX.size()) {
            throw new IllegalArgumentException("[ERROR] 3과 20 사이의 수를 입력하세요.");
        }
    }

    public static void validateMoving(String moving) {
        if (!MOVING_SET.contains(moving)) {
            throw new IllegalArgumentException("[ERROR] 위로 이동하려면 U를, 아래로 이동하려면 D를 입력하세요.");
        }
    }

}
