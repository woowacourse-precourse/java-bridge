package bridge.model;

import bridge.error.Error;
import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<UpOrDown> bridge;

    public Bridge(List<UpOrDown> bridge) {
        if (Objects.isNull(bridge)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        this.bridge = bridge;
    }

    public BridgeSize getBridgeSize() {
        return new BridgeSize(bridge.size());
    }

    public boolean isToCrossed(int index, UpOrDown upOrDown) {
        if (Objects.isNull(upOrDown) || index < 0 || index > bridge.size()) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        return bridge.get(index).equals(upOrDown);
    }
}
