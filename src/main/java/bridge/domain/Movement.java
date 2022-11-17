package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    private final List<String> bridge;
    private List<Moving> movement = new ArrayList<>();
    private int tryCount;

    public Movement(List<String> bridge) {
        this.bridge = bridge;
    }
}