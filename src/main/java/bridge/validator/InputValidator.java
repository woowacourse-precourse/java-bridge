package bridge.validator;

import bridge.domain.BridgeSpec;
import java.util.Set;

public class InputValidator {

    private static final Set<String> MOVING_SET;
    private static final Set<String> GAME_COMMAND_SET;

    static {
        MOVING_SET = Set.of("D", "U");
        GAME_COMMAND_SET = Set.of("R", "Q");
    }

    public static void validateBridgeSize(String input) throws IllegalArgumentException {
        validateNumber(input);
        validateBridgeSize(Integer.parseInt(input));
    }

    public static void validateMoving(String moving) {
        if (!MOVING_SET.contains(moving)) {
            throw new IllegalArgumentException("[ERROR] 위로 이동하려면 U를, 아래로 이동하려면 D를 입력하세요.");
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!GAME_COMMAND_SET.contains(gameCommand)) {
            throw new IllegalArgumentException("[ERROR] 다시 시작하려면 R을, 종료하려면 Q를 입력하세요.");
        }
    }

    private static void validateNumber(String input) {
        for (char cur : input.toCharArray()) {
            if (cur < '0' || cur > '9') {
                throw new IllegalArgumentException("[ERROR] 3과 20 사이의 자연수를 입력하세요.");
            }
        }
    }

    private static void validateBridgeSize(int size) {
        if (size < BridgeSpec.MIN.size() || size > BridgeSpec.MAX.size()) {
            throw new IllegalArgumentException("[ERROR] 3과 20 사이의 자연수를 입력하세요.");
        }
    }

}
