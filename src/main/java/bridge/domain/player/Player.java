package bridge.domain.player;

import bridge.domain.bridge.BridgeDirection;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<String> moving;
    int tryCount;

    public Player() {
        this.moving = new ArrayList<>();
        this.tryCount = 0;
    }

    public void addMoving(String input) {
        moving.add(input);
    }

    public void plusTryCount() {
        this.tryCount += 1;
    }

    public void clear() {
        this.moving.clear();
    }

    public boolean isFull(int size) {
        return moving.size() == size;
    }

    public boolean equalsTop(BridgeDirection direction) {
        return this.getTop().equals(direction.getInitial());
    }

    public int getTopIndex() {
        return moving.size() - 1;
    }

    public String getTop() {
        return moving.get(getTopIndex());
    }

    public int getTryCount() {
        return tryCount;
    }
}
