package bridge.Model;

import bridge.Constant.BridgeValue;
import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private static final int DOWN = 0;
    private static final int UP = 1;
    private final List<Bridge> bridge = new ArrayList<>();

    public BridgeMap() {
        bridge.add(new Bridge()); // 아래 다리
        bridge.add(new Bridge()); // 윗 다리
    }

    private void saveState(final String up, final String down) {
        bridge.get(DOWN).saveCrossedBridge(up);
        bridge.get(UP).saveCrossedBridge(down);
    }

    public boolean isCrossUp(final Bridge rightBridge, final int position) {
        if (rightBridge.getLocationValue(position).equals(BridgeValue.UP.value())) {
            saveState(BridgeValue.TRUE.value(), BridgeValue.EMPTY.value());
            return true;
        }
        saveState(BridgeValue.FALSE.value(), BridgeValue.EMPTY.value());
        return false;
    }

    public boolean isCrossDown(final Bridge rightBridge, final int position) {
        if (rightBridge.getLocationValue(position).equals(BridgeValue.DOWN.value())) {
            saveState(BridgeValue.EMPTY.value(), BridgeValue.TRUE.value());
            return true;
        }
        saveState(BridgeValue.EMPTY.value(), BridgeValue.FALSE.value());
        return false;
    }

}
