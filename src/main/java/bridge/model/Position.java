package bridge.model;

import static bridge.util.BridgeConstant.*;

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
            this.y = UP_POSITION;
            return;
        }
        this.y = DOWN_POSITION;
    }
}
