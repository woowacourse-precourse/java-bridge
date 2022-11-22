package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isEmpty() {
        return bridge.isEmpty();
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }
}