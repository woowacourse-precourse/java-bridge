package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<BridgeUnit> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge.stream()
                .map(BridgeUnit::from)
                .collect(Collectors.toList());
    }

    public BridgeUnit getUnit(int position) {
        return bridge.get(position);
    }

    public int getSize() {
        return bridge.size();
    }
}
