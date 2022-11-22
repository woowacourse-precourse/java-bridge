package bridge.domain.user;

import bridge.domain.Bridge;
import bridge.domain.status.UserStatus;

public class User {
    private final UserPath userPath = new UserPath();
    private int tryCount = 1;
    private int location = 0;

    public User() {
    }

    public UserStatus cross(Bridge bridge, MoveType moveType) {
        if (bridge.canCross(location, moveType)) {
            userPath.addUserPath(true, moveType);
            increaseLocation();
            return UserStatus.SUCCESS;
        }

        userPath.addUserPath(false, moveType);
        return UserStatus.OUT;
    }

    private void increaseLocation() {
        location++;
    }

    private void resetLocation() {
        location = 0;
    }

    private void addTryCount() {
        tryCount++;
    }

    public void resetUserData() {
        resetLocation();
        addTryCount();
        userPath.clearUserPath();
    }

    public String getUserPathLog() {
        return userPath.toString();
    }
}
