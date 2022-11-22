package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canCrossBridge(int phase, String command) {
        return bridge.get(phase)
                .equals(command);
    }

    public String getBridgePhase(int phase) {
        return bridge.get(phase);
    }

    public int length() {
        return bridge.size();
    }
}
