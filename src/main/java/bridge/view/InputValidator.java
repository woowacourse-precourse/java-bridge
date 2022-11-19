package bridge.view;

public class InputValidator {

    public static final String BRIDGE_SIZE_FORMAT = "^[0-9]+$";
    public static final String MOVING_FORMAT = "^[U|D]{1}$";
    public static final String ERR_BRIDGE_SIZE_FORMAT = "[ERROR] 다리 길이는 3 이상 20 이하의 자연수여야 합니다. 예시) 3(O), 18(O), 21(X)";
    public static final String ERR_MOVING_FORMAT = "[ERROR] 윗 칸은 'U', 아랫 칸은 'D'를 입력하세요. 대소문자 구별. 예시) U(O), D(O), d(X)";

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
}
