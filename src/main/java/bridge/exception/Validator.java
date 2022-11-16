package bridge.exception;

import static bridge.constant.BridgeConstant.MAX_SIZE;
import static bridge.constant.BridgeConstant.MIN_SIZE;

public class Validator {

    public void validateBridgeSize(int size) {
        validateBridgeSizeRange(size);
    }

    private void validateBridgeSizeRange(int size) {
        if (size > MAX_SIZE || size < MIN_SIZE) {
            throw new IllegalArgumentException("다리 길이는 3 이상, 20 이하여야합니다. 입력값 : " + size);
        }
    }
}
