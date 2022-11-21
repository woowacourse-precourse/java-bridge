package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> brdige;

    public Bridge() {
        this.brdige = new ArrayList<>();
    }

    public Bridge(List<String> brdige) {
        this.brdige = brdige;
    }

    public List<String> getBrdige() {
        return brdige;
    }

    public static Bridge of (List<String> bridge) {
        return new Bridge(bridge);
    }
}
