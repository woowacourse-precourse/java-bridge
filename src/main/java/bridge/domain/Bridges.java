package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bridges {
    private final List<Bridge> bridges;

    public Bridges() {
        this.bridges = new ArrayList<>();
    }

    public void generate(List<String> realBridges) {
        realBridges.forEach(bridge -> bridges.add(Bridge.create(bridge)));
    }

    public boolean isGameClear() {
        return bridges.stream().allMatch(Bridge::isCrossed);
    }

    public Optional<Bridge> findByPositionToMove(int position) {
        return bridges.stream()
                .filter(bridge -> bridges.indexOf(bridge) == position)
                .findAny();
    }
}
