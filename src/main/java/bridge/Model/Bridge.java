package bridge.Model;

import bridge.Constant.BridgeValue;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(final List<String> bridge) {
        this.bridge = bridge;
    }

    public Bridge() {
        this(new ArrayList<>());
    }

    public void saveCrossedBridge(final String crossed) {
        bridge.add(crossed);
    }

    public String getLocationValue(final int index) {
        return bridge.get(index);
    }

    @Override
    public String toString() {
        return bridge.toString()
            .replaceAll(BridgeValue.OLD.value(), BridgeValue.NEW.value());
    }
}
