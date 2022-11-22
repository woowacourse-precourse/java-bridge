package bridge.domain.user;

import bridge.domain.Bridge;
import bridge.domain.status.UserStatus;

public class User {

    private final UserPath userPath = new UserPath();
    private int tryCount = 1;
    private int nextLocation = 0;

    public User() {
    }

    public UserStatus cross(Bridge bridge, MoveType moveType) {
        if (bridge.canCross(nextLocation, moveType)) {
            userPath.addUserPath(true, moveType);
            increaseLocation();
            return UserStatus.SUCCESS;
        }

        userPath.addUserPath(false, moveType);
        return UserStatus.OUT;
    }

    private void increaseLocation() {
        nextLocation++;
    }

    private void resetLocation() {
        nextLocation = 0;
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

    public boolean isFinish(int bridgeSize) {
        return bridgeSize == nextLocation;
    }

    public int getTryCount() {
        return tryCount;
    }
}
