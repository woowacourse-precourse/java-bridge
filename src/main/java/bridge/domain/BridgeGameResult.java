package bridge.domain;

import java.util.List;
import java.util.Objects;

public class BridgeGameResult {
    private final Bridge bridge;
    private final List<Boolean> booleans;

    public BridgeGameResult(Bridge bridge, List<Boolean> booleans) {
        this.bridge = bridge;
        this.booleans = booleans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BridgeGameResult that = (BridgeGameResult) o;
        return Objects.equals(bridge, that.bridge) && Objects.equals(booleans, that.booleans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridge, booleans);
    }
}
