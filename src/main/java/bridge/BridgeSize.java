package bridge;

public class BridgeSize {
    private final String invalidNumberMessage = "잘못된 입력입니다. 다시 입력해주세요.";
    private final String invalidBridgeSizeMessage = "다리의 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final int minBridgeSize = 3;
    private final int maxBridgeSize = 20;
    private int bridgeSize;

    BridgeSize(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(invalidNumberMessage);
        }
        int bridgeSize = Integer.parseInt(input);
        if (!isValidBridgeSize(bridgeSize)) {
            throw new IllegalArgumentException(invalidBridgeSizeMessage);
        }
        this.bridgeSize = bridgeSize;
    }

    private boolean isNumber(String input) {
        if (input.matches("^[0-9]*$")) {
            return true;
        }
        return false;
    }

    private boolean isValidBridgeSize(int bridgeSize) {
        return bridgeSize >= minBridgeSize && bridgeSize <= maxBridgeSize;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
