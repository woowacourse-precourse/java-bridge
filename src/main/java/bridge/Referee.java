package bridge;

import java.util.Arrays;
import java.util.List;

public class Referee {
    private final List<String> bridge;

    public Referee(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSizeEquals(int currentSize) {
        return currentSize == bridge.size();
    }

    public boolean isStepSuccess(String currentItem, int index) {
        return currentItem.equals(bridge.get(index));
    }

    public boolean compareBridgeWith(List<String> current) {
        return isSizeEquals(current.size()) && Arrays.equals(bridge.toArray(), current.toArray());
    }

}
