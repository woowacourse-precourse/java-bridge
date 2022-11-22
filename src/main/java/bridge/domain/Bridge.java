package bridge.domain;

import java.util.List;

public class Bridge {

    public static final int MIN_BOUND = 3;
    public static final int MAX_BOUND = 20;

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canCrossBridge(int phase, String command) {
        return bridge.get(phase)
                .equals(command);
    }
}
