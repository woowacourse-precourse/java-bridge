package bridge.domain;

import bridge.validate.Exception;

public class Bridge {

    private final int bridgeLength;

    public Bridge(int bridgeLength) {
        Exception.validateThreeToTwenty(bridgeLength);
        this.bridgeLength = bridgeLength;
    }

    public int getBridgeLength() {
        return bridgeLength;
    }
}
