package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private static int stepCount = 0;
    public Bridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public String getBridge() {
        return bridge.get(stepCount);
    }

    public void netStep(){
        this.stepCount +=1;
    }
}