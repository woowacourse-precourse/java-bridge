package bridge.domain.user;

import bridge.domain.Bridge;
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
        int currentPosition = userData.getPosition();
        if (bridge.canCross(currentPosition, direction)) {
            userData.increasePosition();
            footPrints.addStep(User.LIVE, direction);
            return LIVE;
        }
        footPrints.addStep(User.DEAD, direction);
        return DEAD;
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
