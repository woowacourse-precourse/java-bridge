package bridge.Domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isBridgeFinished(int distance) {
        return this.bridge.size() > distance;
    }

    public boolean canCrossBridge(int distance, String position) {
        return bridge.get(distance).equals(position); 
    }
}
