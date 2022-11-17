package bridge;

public class BridgeLength {
    private final int length;
    private static final int MINIMUM_LENGTH = 3;
    private static final int MAXIMUM_LENGTH = 20;

    public BridgeLength(int length) {
        validateLength(length);
        this.length = length;
    }

    private void validateLength(int length) {
        if (length < MINIMUM_LENGTH || length > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
