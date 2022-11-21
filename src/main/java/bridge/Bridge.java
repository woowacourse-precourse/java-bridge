package bridge;

import java.util.List;

public class Bridge {
    public final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
