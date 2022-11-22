package bridge.domain.bridge;

public class BridgeSize {
    public static final String CHAR_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    public static final String ERROR_BRIDGE_SIZE_RANGE = "[ERROR] 3~20 사이의 자연수만 입력해주세요";

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int bridgeSize;

    public BridgeSize(String inputBridgeSize) {
        validateBridgeSize(inputBridgeSize);
        this.bridgeSize = Integer.parseInt(inputBridgeSize);
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public void validateBridgeSize(String size){
        checkChar(size);
        checkRange(Integer.parseInt(size));
    }

    public void checkChar(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(CHAR_ERROR_MESSAGE);
        }
    }

    public void checkRange(int bridgeSize) {
        if(bridgeSize < MIN_SIZE || MAX_SIZE < bridgeSize) {
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_RANGE);
        }
    }
}
