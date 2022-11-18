package bridge.domain;

import static bridge.common.message.ExceptionMessage.ERROR_CODE;

public class Bridge {

    private Integer bridgeSize;

    private Bridge(Integer bridgeSize) {
        this.bridgeSize = bridgeSize;
    }

    public static Bridge from(Integer bridgeSize) {
        return new Bridge(bridgeSize);
    }
}
