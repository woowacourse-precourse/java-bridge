package bridge.utils.value;

import static bridge.utils.message.ErrorMessagesUtil.ONLY_NUMBERS;
import static bridge.utils.message.ErrorMessagesUtil.SIZE_OUT_OF_RANGE;

import java.util.regex.Pattern;

public class BridgeSize {
    private final int size;

    public BridgeSize(int size) {
        this(String.valueOf(size));
    }

    public BridgeSize(String size) {
        validateBridgeSize(size);
        this.size = Integer.parseInt(size);
    }

    private void validateBridgeSize(String size) {
        if (Pattern.matches(".*\\D.*", size)) { // 문자가 섞이면 예외 발생
            throw new IllegalArgumentException(ONLY_NUMBERS.getMessage());
        }

        if (Integer.parseInt(size) < 3 || Integer.parseInt(size) > 20) {
            throw new IllegalArgumentException(SIZE_OUT_OF_RANGE.getMessage());
        }
    }

    public int getSize() {
        return size;
    }
}
