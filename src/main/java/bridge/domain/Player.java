package bridge.domain;

import static bridge.util.constants.ErrorMessage.MOVE_INVALID_ERROR;

public class Player {
    private final int INITIAL_PLAYER_LOCATION_INDEX = 0;
    private int currentSpaceIndex;
    private boolean alive;

    public Player() {
        currentSpaceIndex = INITIAL_PLAYER_LOCATION_INDEX;
        alive = true;
    }

    public void move(Bridge bridge, String spaceToMove) {
        if (isDead() || isArrived(bridge)) {
            throw new IllegalStateException(MOVE_INVALID_ERROR.getMessage());
        }
        currentSpaceIndex += 1;
        if (bridge.isBroken(currentSpaceIndex, spaceToMove)) {
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
        currentSpaceIndex = INITIAL_PLAYER_LOCATION_INDEX;
        alive = true;
    }
}
