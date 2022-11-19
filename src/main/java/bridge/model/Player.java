package bridge.model;

import static bridge.util.BridgeConstant.*;

public class Player {
    private Position position;
    private int tryCount;

    public Player() {
        this.position = new Position();
        this.tryCount = 1;
    }

    public int getXPosition() {
        return position.getPositionX();
    }

    public int getYPosition() {
        return position.getPositionY();
    }

    public void setPosition(String moveTo) {
        position.setPositionX();
        position.setPositionY(moveTo);
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addTryCount() {
        this.tryCount += 1;
    }

    public void initializePosition() {
        this.position = new Position();
    }
}
