package bridge.domain;

public class BridgeLength {
    private final int length;
    private static int MIN_BRIDGE_LENGTH = 3;
    private static int MAX_BRIDGE_LENGTH = 20;

    public BridgeLength(int length) {
        checkLengthIsInRange(length);
        this.length = length;
    }

    private void checkLengthIsInRange(int size) {
        if (size < MIN_BRIDGE_LENGTH || size > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException("다리의 길이는 3부터 20 사이의 자연수여야 합니다.");
        }
    }

    public boolean isEqualTo(int length){
        return this.length == length;
    }

    public int getLength() {
        return this.length;
    }
}
