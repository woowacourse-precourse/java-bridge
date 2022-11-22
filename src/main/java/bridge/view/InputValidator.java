package bridge.view;

public class InputValidator {
    private static final String BRIDGE_SIZE_FORMAT = "^[0-9]+$";
    private static final String MOVING_FORMAT = "^[U|D]{1}$";
    private static final String GAME_COMMAND_FORMAT = "^[R|Q]{1}$";
    private static final String ERR_BRIDGE_SIZE_FORMAT = "다리 길이는 3 이상 20 이하의 자연수여야 합니다. 예시) 3(O), 18(O), 21(X)";
    private static final String ERR_MOVING_FORMAT = "윗 칸은 'U', 아랫 칸은 'D'를 입력하세요. 대소문자 구별. 예시) U(O), D(O), d(X)";
    private static final String ERR_GAME_COMMAND_FORMAT = "게임 재시도는 'R', 종료는 'Q'를 입력하세요. 대소문자 구별. 예시) R(O), Q(O), r(X)";

    public static void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches(BRIDGE_SIZE_FORMAT)) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE_FORMAT);
        }
    }

    public static void validateMoving(String moving) {
        if (!moving.matches(MOVING_FORMAT)) {
            throw new IllegalArgumentException(ERR_MOVING_FORMAT);
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches(GAME_COMMAND_FORMAT)) {
            throw new IllegalArgumentException(ERR_GAME_COMMAND_FORMAT);
        }
    }
}
