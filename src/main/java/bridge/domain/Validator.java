package bridge.domain;

public class Validator {
    static final private String BRIDGE_SIZE_NOT_NUMBER = "[ERROR] 다리 길이는 숫자로 입력 가능합니다.";
    static final private String BRIDGE_SIZE_WRONG_RANGE = "[ERROR] 다리 길이는 3 이상 20 이하로 입력해야 합니다.";

    public static void validateBridgeSize(String bridgeSize) {
        validateNumber(bridgeSize);
        validateRange(bridgeSize);
    }

    private static void validateNumber(String bridgeSize) {
        if(!bridgeSize.matches("\\d+")){
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_NUMBER);
        }
    }

    private static void validateRange(String bridgeSize) {
        if(!bridgeSize.matches("^[3-9]$|^1\\d$|^20$")){
            throw new IllegalArgumentException(BRIDGE_SIZE_WRONG_RANGE);
        }
    }
}
