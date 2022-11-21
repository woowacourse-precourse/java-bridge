package bridge;

public class BridgeSize {

    private static final int BRIDGE_MIN_LENGTH = 3;
    private static final int BRIDGE_MAX_LENGTH = 20;

    private final int size;

    public BridgeSize(String bridgeSize) {
        this.size = validate(bridgeSize);
    }

    private int validate(String bridgeSize) {
        return validateLength(validateNumberType(validateBlank(bridgeSize)));
    }

    private String validateBlank(String bridgeSize) {
        if (bridgeSize.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 공백입니다.");
        }
        return bridgeSize;
    }

    private int validateNumberType(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exceptionMessage) {
            throw new NumberFormatException("[ERROR] 입력한 값이 숫자가 아닙니다.");
        }
    }

    private int validateLength(int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_LENGTH || bridgeSize > BRIDGE_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 범위를 벗어났습니다.");
        }
        return bridgeSize;
    }

    public int getSize() {
        return this.size;
    }

}
