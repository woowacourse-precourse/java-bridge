package bridge.Model;

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

}
