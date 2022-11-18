package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int size() {
        return this.bridge.size();
    }

    public boolean isEqual(String inputBridge, int index) {
        return bridge.get(index).equals(inputBridge);
    }
}
