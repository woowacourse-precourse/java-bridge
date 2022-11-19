package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSafe(int step, String command) {
        return bridge.get(step).equals(command);
    }

    public int getSize() {
        return bridge.size();
    }
}
