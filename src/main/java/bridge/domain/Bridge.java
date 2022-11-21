package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge (BridgeLength length) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(length.get());
    }

    public boolean isCorrectPanel (int order, String choice) {
        return bridge.get(--order).equals(choice);
    }

    public boolean isEnd(int order) {
        return order == bridge.size();
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getLength() {
        return bridge.size();
    }
}
