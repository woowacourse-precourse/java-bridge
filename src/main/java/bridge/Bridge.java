package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final static int ONE = 1;

    private final List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public void registerBridge(List<String> bridge) {
        this.bridge.addAll(bridge);
    }

    public boolean isMatchBothIndexAndString(String string, int index) {
        if(bridge.get(index).equals(string)) {
            return true;
        }
        return false;
    }

    public boolean isLastCount(int count) {
        if(count == bridge.size() - ONE) {
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return new ArrayList<>(this.bridge);
    }

}
