package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int pivot;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
        pivot = 0;
    }

    public String next() {
        return bridge.get(pivot++);
    }

    public void reset() {
        pivot = 0;
    }
}
