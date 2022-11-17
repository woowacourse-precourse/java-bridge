package bridge.domain;

import java.util.List;

public class BridgeMatcher {

    private final List<Boolean> matchedBridge;

    public BridgeMatcher(List<Boolean> bridge) {
        this.matchedBridge = bridge;
    }

    public int calculateSize() {
        return matchedBridge.size();
    }

    public void addTrueOrFalse(boolean bool) {
        matchedBridge.add(bool);
    }
}