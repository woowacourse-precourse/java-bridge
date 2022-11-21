package bridge.domain;

import static bridge.util.constants.ErrorMessage.MOVE_INVALID_ERROR;

public class Player {
    private int currentSpaceIndex;
    private boolean alive;

    public Player() {
        currentSpaceIndex = 0;
        alive = true;
    }

    public void move(Bridge bridge, String spaceToMove) {
        if (isDead() || isArrived(bridge)) {
            throw new IllegalStateException(MOVE_INVALID_ERROR.getMessage());
        }
        int nextSpaceIndex = currentSpaceIndex + 1;
        currentSpaceIndex += 1;
        if (bridge.isBroken(nextSpaceIndex, spaceToMove)) {
            fallOff();
        }
    }

    private void fallOff() {
        alive = false;
    }

    public boolean isDead() {
        return !alive;
    }

    public boolean isArrived(Bridge bridge) {
        if (isDead()) {
            return false;
        }
        return currentSpaceIndex == bridge.size();
    }

    public void reVive() {
        currentSpaceIndex = 0;
        alive = true;
    }
}
