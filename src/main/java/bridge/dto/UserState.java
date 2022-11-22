package bridge.dto;

import bridge.domain.Bridge;

public class UserState {
    private final Bridge bridge;
    private final int userPosition;
    private final boolean aliveUser;

    public UserState(Bridge bridge, int userPosition, boolean aliveUser) {
        this.bridge = bridge;
        this.userPosition = userPosition;
        this.aliveUser = aliveUser;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public int getUserPosition() {
        return userPosition;
    }

    public boolean isAliveUser() {
        return aliveUser;
    }
}
