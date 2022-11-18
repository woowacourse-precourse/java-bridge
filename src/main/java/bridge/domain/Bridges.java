package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    private final List<Bridge> bridges;

    public Bridges() {
        this.bridges = new ArrayList<>();
    }

    public void generate(List<String> realBridges) {
        realBridges.forEach(bridge -> bridges.add(Bridge.create(bridge)));
    }
}
