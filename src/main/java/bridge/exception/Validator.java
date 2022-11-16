package bridge.exception;

import static bridge.constant.BridgeConstant.LOWER_BLOCK;
import static bridge.constant.BridgeConstant.MAX_SIZE;
import static bridge.constant.BridgeConstant.MIN_SIZE;
import static bridge.constant.BridgeConstant.UPPER_BLOCK;

public class Validator {

    public void validateBridgeSize(int size) {
        validateBridgeSizeRange(size);
    }

    public void validateMoveMessage(String message) {
        if (!message.equals(UPPER_BLOCK) && !message.equals(LOWER_BLOCK)) {
            throw new IllegalArgumentException("입력 값은 " + UPPER_BLOCK + "혹은 " + LOWER_BLOCK + "이여야 합니다." +
                    "입력값 : " + message);
        }
    }

    private void validateBridgeSizeRange(int size) {
        if (size > MAX_SIZE || size < MIN_SIZE) {
            throw new IllegalArgumentException("다리 길이는 3 이상, 20 이하여야합니다. 입력값 : " + size);
        }
    }
}
