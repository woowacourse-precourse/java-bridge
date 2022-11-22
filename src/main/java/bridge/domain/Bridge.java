package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(int size, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public List<String> get() {
        return bridge;
    }

    public String getStep(int position) {
        return bridge.get(position);
    }

    public boolean isFinal(int position) {
        return bridge.size() == position;
    }

    public String toString() {
        return "Bridge{" +
            "steps=" + bridge +
            '}';
    }

}