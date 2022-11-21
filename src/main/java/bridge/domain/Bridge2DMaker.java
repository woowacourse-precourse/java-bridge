package bridge.domain;

import java.util.List;

import static bridge.util.BridgeConstant.UP_POSITION;
import static bridge.util.BridgeConstant.DOWN_POSITION;
import static bridge.util.BridgeConstant.UP_KEY;
import static bridge.util.BridgeConstant.DOWN_KEY;
import static bridge.util.BridgeConstant.FALL_BLOCK;

public class Bridge2DMaker {
    private final int BRIDGE_WIDTH = 2;

    public String[][] make2DBridge(List<String> bridge) {
        String[][] bridge2D = new String[BRIDGE_WIDTH][bridge.size()];
        for (int x = 0; x < bridge.size(); x++) {
            String key = bridge.get(x);
            bridge2D[UP_POSITION][x] = getKey(UP_POSITION, key);
            bridge2D[DOWN_POSITION][x] = getKey(DOWN_POSITION, key);
        }
        return bridge2D;
    }

    private String getKey(int index, String key) {
        if (index == UP_POSITION && key.equals(UP_KEY)) {
            return UP_KEY;
        } else if (index == DOWN_POSITION && key.equals(DOWN_KEY)) {
            return DOWN_KEY;
        }
        return FALL_BLOCK;
    }
}
