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

    public boolean isSame(Bridge other) {
        return other.isSameValue(bridge);
    }

    public boolean isSameValue(List<String> other) {
        return bridge.equals(other);
    }

    public int length() {
        return bridge.size();
    }
}
