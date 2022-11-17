package bridge.domain;

import bridge.exception.NotFoundBridgeStateException;

import java.util.ArrayList;
import java.util.List;

public class Bridges {
    private final List<Bridge> bridges;

    public Bridges() {
        this.bridges = new ArrayList<>();
    }

    public void generate(List<String> bridges) {
        bridges.forEach(bridge -> {
            BridgeState bridgeState = BridgeState.findByPlayerValue(bridge)
                    .orElseThrow(NotFoundBridgeStateException::new);
            this.bridges.add(Bridge.create(bridgeState));
        });
    }

    public boolean isCrossAllBridges() {
        return bridges.stream()
                .allMatch(Bridge::isAlreadyCrossed);
    }
}
