package bridge.domain;

import java.util.List;

public class BridgeMover {
    private List<String> bridge;
    private int location;

    public BridgeMover(List<String> bridge) {
        this.bridge = bridge;
        this.location = 0;
    }
}
