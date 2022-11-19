package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private int bridgeSize;
    private List<String> bridge;
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);


    public Bridge(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        bridge = setBridgeInfo(bridgeSize);
    }

    private List<String> setBridgeInfo(int bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public String getBridge(int index) {
        return bridge.get(index);
    }

}
