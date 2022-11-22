package bridge.validator;

import bridge.domain.BridgeSpec;
import bridge.domain.GameCommand;
import bridge.domain.Moving;
import java.util.Set;

public class InputValidator {

    private static final Set<String> MOVING_SET;
    private static final Set<String> GAME_COMMAND_SET;

    static {
        MOVING_SET = Set.of(
                Moving.UP.direction(),
                Moving.DOWN.direction()
        );
        GAME_COMMAND_SET = Set.of(
                GameCommand.RETRY.command(),
                GameCommand.QUIT.command()
        );
    }

    public static void validateBridgeSize(String input) throws IllegalArgumentException {
        validateNumber(input);
        validateBridgeSize(Integer.parseInt(input));
    }

    public static void validateMoving(String moving) {
        if (!MOVING_SET.contains(moving)) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] 위로 이동하려면 %s를, 아래로 이동하려면 %s를 입력하세요.",
                            Moving.UP.direction(),
                            Moving.DOWN.direction()
                    )
            );
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!GAME_COMMAND_SET.contains(gameCommand)) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] 다시 시작하려면 %s을, 종료하려면 %s를 입력하세요.",
                            GameCommand.RETRY.command(),
                            GameCommand.QUIT.command()
                    )
            );
        }
    }

    private static void validateNumber(String input) {
        for (char cur : input.toCharArray()) {
            if (cur < '0' || cur > '9') {
                throw new IllegalArgumentException("[ERROR] 수를 입력하세요.");
            }
        }
    }

    private static void validateBridgeSize(int size) {
        if (size < BridgeSpec.MIN.size() || size > BridgeSpec.MAX.size()) {
            throw new IllegalArgumentException(
                    String.format(
                            "[ERROR] %d과 %d 사이의 자연수를 입력하세요.",
                            BridgeSpec.MIN.size(),
                            BridgeSpec.MAX.size()
                    )
            );
        }
    }

}
