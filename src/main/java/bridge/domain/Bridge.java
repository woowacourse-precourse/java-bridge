package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    List<String>bridge;

    public Bridge(int size){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public String get(int index) {
        return bridge.get(index);
    }
}
