package bridge.domain;

import bridge.domain.enums.Direction;

public class User {

    public static final int DEAD = 0;
    public static final int LIVE = 1;

    private final FootPrints footPrints;
    private final UserData userData;

    public User() {
        footPrints = new FootPrints();
        userData = new UserData();
    }

    public int cross(Bridge bridge, Direction direction) {
        if (bridge.canCross(userData.getPosition(), direction)) {
            userData.increasePosition();
            recordStep(LIVE, direction);
            return LIVE;
        }
        recordStep(DEAD, direction);
        return DEAD;
    }

    public void recordStep(int status, Direction direction) {
        footPrints.add(status, direction);
    }

    public boolean isLocateAt(int position) {
        return userData.isSamePosition(position);
    }

    public String getFootPrintsLog() {
        return footPrints.toString();
    }

    public void prepareToRestart() {
        footPrints.reset();
        userData.resetPosition();
        userData.increaseTryCount();
    }

    public int getTryCount() {
        return userData.getTryCount();
    }
}
