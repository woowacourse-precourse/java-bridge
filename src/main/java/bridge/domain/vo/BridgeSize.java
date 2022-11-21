package bridge.domain.vo;

import static java.text.MessageFormat.format;

public class BridgeSize {

    public static final int MAX_SIZE = 20;
    public static final int MIN_SIZE = 3;

    private final int size;

    public BridgeSize(int size) {
        validate(size);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    private void validate(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(format("다리 길이는 {0} 이상, {1} 이하여야 합니다. 입력값 : {2}",
                    MIN_SIZE, MAX_SIZE, size));
        }
    }
}
