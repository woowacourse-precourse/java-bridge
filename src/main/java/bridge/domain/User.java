package bridge.domain;

import bridge.dto.UserState;

public class User {
    private static final String MOVING_ERROR_MESSAGE = "[ERROR] 유저가 이동할 수 없는 상태입니다.";

    private Bridge bridge;
    private int userPosition;
    private boolean aliveUser;

    public User(Bridge bridge) {
        this.bridge = bridge;
        this.userPosition = 0;
        this.aliveUser = true;
    }

    public void move(Direction direction) {
        movingValidation();
        userPosition++;
        checkLife(direction);
    }

    public boolean reachEndOfBridge() {
        return bridge.isEndOfBridge(userPosition);
    }

    public boolean isAlive() {
        return aliveUser;
    }

    public UserState getUserState() {
        return new UserState(bridge, userPosition, aliveUser);
    }

    public void revive() {
        userPosition = 0;
        aliveUser = true;
    }

    private void movingValidation() {
        if (!aliveUser || bridge.isEndOfBridge(userPosition)) {
            throw new IllegalArgumentException(MOVING_ERROR_MESSAGE);
        }
    }

    private void checkLife(Direction direction) {
        if (!bridge.isCorrectDirection(direction, userPosition)) {
            aliveUser = false;
        }
    }
}
