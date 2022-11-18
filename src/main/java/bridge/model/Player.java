package bridge.model;

import static bridge.util.BridgeConstant.*;

public class Player {
    private Position position;
    private int tryCount;

    public Player() {
        this.position = new Position();
        this.tryCount = 0;
    }

    public int getXPosition() {
        return position.x;
    }

    public int getYPosition() {
        return position.y;
    }

    public void setPosition(String moveTo) {
        this.position.x += 1;
        if (moveTo.equals(UP_KEY)) {
            this.position.y = UP;
        } else if (moveTo.equals(DOWN_KEY)) {
            this.position.y = DOWN;
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount() {
        this.tryCount += 1;
    }

    public void initializePosition() {
        this.position = new Position();
    }
}
