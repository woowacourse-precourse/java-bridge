package bridge.view;

public class InputValidator {

    public static final String BRIDGE_SIZE_FORMAT = "^[0-9]+$";
    public static final String ERR_BRIDGES_SIZE = "[ERROR] 다리 길이는 3 이상 20 이하의 자연수여야 합니다. 예시) 3(O), 18(O), 21(X)";

    public static void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches(BRIDGE_SIZE_FORMAT)) {
            throw new IllegalArgumentException(ERR_BRIDGES_SIZE);
        }
    }
}
