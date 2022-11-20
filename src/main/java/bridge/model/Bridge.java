package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private int size;
    private final List<String> bridge = new ArrayList<>();

    public Bridge(int size, List<String> bridge) {
        this.size = size;
        this.bridge.addAll(bridge);
    }
}
