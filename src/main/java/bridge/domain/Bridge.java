package bridge.domain;


import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int location;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.location = 0;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getLocation() {
        return location;
    }
}
