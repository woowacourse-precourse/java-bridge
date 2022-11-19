package bridge.domain;

import static bridge.constant.BridgeConstant.MAX_SIZE;
import static bridge.constant.BridgeConstant.MIN_SIZE;
import static java.text.MessageFormat.format;

public class BridgeSize {

    private int size;

    public BridgeSize(int size) {
        validate(size);
        this.size = size;
    }

    private void validate(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(format("다리 길이는 {0} 이상, {1} 이하여야 합니다. " + "입력값 : {2}",
                    MIN_SIZE, MAX_SIZE, size));
        }
    }

    public int getSize() {
        return size;
    }
}
