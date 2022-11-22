package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public void registerBridge(List<String> bridge) {
        this.bridge.addAll(bridge);
    }

    public boolean isMatchBothIndexAndString(String string, int index) {
        if (bridge.get(index).equals(string)) {
            return true;
        }
        return false;
    }

    public boolean isLastCount(int count) {
        if (count == bridge.size()) {
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return new ArrayList<>(this.bridge);
    }

    public List<String> createBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        List<String> newBridge = bridgeMaker.makeBridge(bridgeSize);

        return newBridge;
    }

}
