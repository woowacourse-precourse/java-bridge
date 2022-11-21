package bridge.domain.bridge;

public class BridgeSize {

    private int size;

    public BridgeSize(int size) {
        validate(size);
        this.size = size;
    }

    public static BridgeSize makeBridgeSize(int length) {
        return new BridgeSize(length);
    }

    public int value() {
        return size;
    }

    private void validate(int size) {
        if (!(3 <= size && size <= 20)) {
            throw new IllegalArgumentException("다리의 길이가 범위에 해당되지 않습니다.");
        }
    }
}
