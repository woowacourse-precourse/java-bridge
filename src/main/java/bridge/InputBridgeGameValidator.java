package bridge;

public class InputBridgeGameValidator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String IS_DIGIT_ERROR = "[ERROR] 숫자를 입력하여야 합니다.";
    private static final String BRIDGE_SIZE_RANGE_ERROR = "[ERROR] 3 이상 20 이하의 숫자를 입력하여야 합니다.";

    public void isDigit(String bridgeSize) {
        if (bridgeSize.equals("")) {
            throw new IllegalArgumentException(IS_DIGIT_ERROR);
        }

        for (int i = 0; i < bridgeSize.length(); i++) {
            if (!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException(IS_DIGIT_ERROR);
            }
        }
    }

    public void checkBridgeSizeRange(String bridgeSize) {
        int getBridgeSize = Integer.parseInt(bridgeSize);

        if(!(getBridgeSize >= MIN_BRIDGE_SIZE && getBridgeSize <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR);
        }
    }

    public void validateBridgeSize(String bridgeSize) {
        isDigit(bridgeSize);
        checkBridgeSizeRange(bridgeSize);
    }
}
