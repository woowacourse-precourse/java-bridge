package bridge.domain;

import java.util.List;

import static bridge.util.BridgeConstant.UPPER_BRIDGE;
import static bridge.util.BridgeConstant.LOWER_BRIDGE;
import static bridge.util.BridgeConstant.UP_KEY;
import static bridge.util.BridgeConstant.DOWN_KEY;
import static bridge.util.BridgeConstant.FALL_BLOCK;

public class Bridge2DMaker {
    private final int BRIDGE_WIDTH = 2;

    public String[][] make2DBridge(List<String> bridge) {
        String[][] bridge2D = new String[BRIDGE_WIDTH][bridge.size()];
        for (int x = 0; x < bridge.size(); x++) {
            String key = bridge.get(x);
            bridge2D[UPPER_BRIDGE][x] = getKey(UPPER_BRIDGE, key);
            bridge2D[LOWER_BRIDGE][x] = getKey(LOWER_BRIDGE, key);
        }
        return bridge2D;
    }

    private String getKey(int index, String key) {
        if (index == UPPER_BRIDGE && key.equals(UP_KEY)) {
            return UP_KEY;
        } else if (index == LOWER_BRIDGE && key.equals(DOWN_KEY)) {
            return DOWN_KEY;
        }
        return FALL_BLOCK;
    }
}
