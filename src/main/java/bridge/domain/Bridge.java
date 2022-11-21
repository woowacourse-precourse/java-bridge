package bridge.domain;

import bridge.exception.BridgeException;

import java.util.List;

public class Bridge {
    private int bridgeLength;
    private List<String> resultBridge;

    public Bridge(int bridgeLength, List<String> resultBridge){
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
