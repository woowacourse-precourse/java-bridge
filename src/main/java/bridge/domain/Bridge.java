package bridge.domain;

import static bridge.common.message.ExceptionMessage.BRIDGE_LENGTH_OUT_OF_SIZE_MESSAGE;
import static bridge.common.message.ExceptionMessage.ERROR_CODE;

public class Bridge {

    private Integer bridgeSize;

    private Bridge(Integer bridgeSize) {
        bridgeSizeValidation(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private void bridgeSizeValidation(Integer bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_CODE + BRIDGE_LENGTH_OUT_OF_SIZE_MESSAGE);
        }
    }

    public static Bridge from(Integer bridgeSize) {
        return new Bridge(bridgeSize);
    }
}
