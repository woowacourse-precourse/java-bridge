package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    private final List<Bridge> bridges;

    public Bridges() {
        this.bridges = new ArrayList<>();
    }

    public void generate(List<String> bridges) {
        bridges.forEach(bridge -> {
            BridgeState bridgeState = BridgeState.valueOfUser(bridge);
            this.bridges.add(Bridge.create(bridgeState));
        });
    }
}
