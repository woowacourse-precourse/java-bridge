package bridge.domain;

import java.util.List;

public class Bridge {
    private final int bridgeLength;
    private final List<String> resultBridge;

    public Bridge(int bridgeLength, List<String> resultBridge) {
        this.bridgeLength = bridgeLength;
        this.resultBridge = resultBridge;
    }


    public int getBridgeLength() {
        return bridgeLength;
    }

    public List<String> getResultBridge() {
        return resultBridge;
    }
}
