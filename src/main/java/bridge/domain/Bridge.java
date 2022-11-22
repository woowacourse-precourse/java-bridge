package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public boolean matches(int index, String direction) {
        return direction.equals(bridge.get(index));
    }
}
