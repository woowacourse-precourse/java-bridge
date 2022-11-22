package bridge.domain;

import java.util.List;

public class BridgeMatcher {

    private List<Boolean> matchedBridge;
    private int tryCount;

    public BridgeMatcher(List<Boolean> matchedBridge, int tryCount) {
        this.matchedBridge = matchedBridge;
        this.tryCount = tryCount;
    }

    public int calculateSize() {
        return matchedBridge.size();
    }

    public void addTrueOrFalse(boolean bool) {
        matchedBridge.add(bool);
    }

    public boolean getLatestTry() {
        return matchedBridge.get(matchedBridge.size() - 1);
    }

    public boolean isGameSuccess(List<String> bridge) {
        return matchedBridge.size() == bridge.size() && !matchedBridge.contains(false);
    }

    public void clearBridgeMatcher() {
        matchedBridge.clear();
    }

    public void tryAgain() {
        tryCount += 1;
    }

    public int getTryCount() {
        return tryCount;
    }
}