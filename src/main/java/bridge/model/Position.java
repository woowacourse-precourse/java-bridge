package bridge.model;

import static bridge.util.BridgeConstant.UPPER_BRIDGE;
import static bridge.util.BridgeConstant.LOWER_BRIDGE;
import static bridge.util.BridgeConstant.UP_KEY;

public class Position {
    private int x, y;

    public Position() {
        this.x = -1;
        this.y = -1;
    }

    public int getPositionX() {
        return x;
    }

    public int getPositionY() {
        return y;
    }

    public void setPositionX() {
        x++;
    }

    public void setPositionY(String moveTo) {
        if (moveTo.equals(UP_KEY)) {
            this.y = UPPER_BRIDGE;
            return;
        }
        this.y = LOWER_BRIDGE;
    }
}
