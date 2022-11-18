package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void addBlock(String moving) {
        bridge.add(moving);
    }

    public void reset() {
        bridge = new ArrayList<>();
    }

    // delete later
    public boolean isSame(Bridge other) {
        return other.isSameValue(bridge);
    }

    // delete later
    public boolean isSameValue(List<String> other) {
        return bridge.equals(other);
    }

    public int length() {
        return bridge.size();
    }

    public boolean isPartOfBridge(Bridge otherBridge) {
        return otherBridge.isPartOfList(bridge);
    }

    public boolean isPartOfList(List<String> other) {
        List<String> temp = bridge.subList(0, other.size());
        return temp.equals(other);
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
