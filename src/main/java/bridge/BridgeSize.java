package bridge;

public class BridgeSize {

    private final int size;
    private static final String WRONG_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public BridgeSize(String size) {
        this.size = validateBridgeSize(toInt(size));
    }

    private int toInt(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_SIZE);
        }
    }

    private int validateBridgeSize(int size) {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException(WRONG_SIZE);
        return size;
    }
}
