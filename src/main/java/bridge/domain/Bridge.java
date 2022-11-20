package bridge.domain;

import bridge.verifier.BridgeSizeVerifier;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        BridgeSizeVerifier bridgeSizeVerifier = new BridgeSizeVerifier();
        int bridgeSize = bridge.size();
        bridgeSizeVerifier.check(String.valueOf(bridgeSize));

        this.bridge = bridge;
    }

    public void addBlock(String moving) {
        bridge.add(moving);
    }

    public void reset() {
        bridge = new ArrayList<>();
    }

    public int length() {
        return bridge.size();
    }

    public boolean isPartOfBridge(Bridge otherBridge) {
        return otherBridge.containsAll(bridge);
    }

    public boolean containsAll(List<String> other) {
        List<String> temp = bridge.subList(0, other.size());
        return temp.equals(other);
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
