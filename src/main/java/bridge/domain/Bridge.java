package bridge.domain;

import java.util.List;

public class Bridge {
    private final int bridgeLength;
    private final List<String> bridgeResult;

    public Bridge(int bridgeLength, List<String> bridgeResult) {
        this.bridgeLength = bridgeLength;
        this.bridgeResult = bridgeResult;
    }


    public int getBridgeLength() {
        return bridgeLength;
    }

    public List<String> getBridgeResult() {
        return bridgeResult;
    }
}
