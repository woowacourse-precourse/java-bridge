package bridge.Model;


import bridge.Utils.Bridge.BridgeMaker;
import bridge.Utils.Bridge.BridgeNumberGenerator;
import bridge.Utils.Bridge.BridgeRandomNumberGenerator;

import java.util.List;


public class Bridge {
    private final List<String> bridge;

    public Bridge(int size) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }


    public List<String> getBridge() {
        return this.bridge;
    }

}

