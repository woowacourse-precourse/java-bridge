package bridge.domain.user;

import bridge.domain.Bridge;

public class User {
    private final UserPath userPath = new UserPath();
    private int tryCount = 1;
    private int location = 0;

    public User() {
    }

    public void cross(Bridge bridge, MoveType moveType) {
        if (bridge.canCross(location, moveType)) {
            userPath.addUserPath(true, moveType);
            return;
        }

        userPath.addUserPath(false, moveType);
        increaseLocation();
    }

    private void increaseLocation() {
        location++;
    }

    public String getUserPathLog() {
        return userPath.toString();
    }
}
