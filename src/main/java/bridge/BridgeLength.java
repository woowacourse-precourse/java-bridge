package bridge;

public class BridgeLength {

    public static final int EMPTY_CRITERIA = 0;
    public static final int BRIDGE_LENGTH_MAX = 20;
    public static final int BRIDGE_LENGTH_MIN = 3;
    public static final String BLANK_CRITERIA = " ";

    private final int bridgeLength;

    public BridgeLength(String bridgeLength) {
        this.bridgeLength = validate(bridgeLength);
    }

    private int validate(String bridgeLength) {
        validateEmpty(bridgeLength);
        validateBlank(bridgeLength);
        int newBridgeLength = validateNumber(bridgeLength);
        validateMaxBridgeLength(newBridgeLength);
        validateMinBridgeLength(newBridgeLength);
        return newBridgeLength;
    }

    private void validateEmpty(String bridgeLength) {
        if (bridgeLength.length() == EMPTY_CRITERIA) {
            throw new IllegalArgumentException("[ERROR] 입력을 하지 않았습니다.");
        }
    }

    private void validateBlank(String bridgeLength) {
        if (bridgeLength.contains(BLANK_CRITERIA)) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 공백이 포함 되어있습니다.");
        }
    }

    private int validateNumber(String bridgeLength) {
        try {
            return Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 입력 값이 숫자가 아닙니다.");
        }
    }

    private void validateMaxBridgeLength(int bridgeLength) {
        if (bridgeLength > BRIDGE_LENGTH_MAX) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 너무 큽니다.");
        }
    }

    private void validateMinBridgeLength(int bridgeLength) {
        if (bridgeLength < BRIDGE_LENGTH_MIN) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 너무 작습니다.");
        }
    }

    public int getBridgeLength() {
        return this.bridgeLength;
    }

}
