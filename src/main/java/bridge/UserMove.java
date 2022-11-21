package bridge;

import java.util.ArrayList;
import java.util.List;

public class UserMove {
    private int tryCount = 1;
    private int moveCount = 0;
    private int userBridgeSize = 0;
    private List<String> userLocation = new ArrayList<>();


    public void initMove() {
        moveCount = 0;
        userLocation = new ArrayList<>();
    }

    public int getUserBridgeSize() {
        return userBridgeSize;
    }

    public void setUserBridgeSize(int userBridgeSize) {
        this.userBridgeSize = userBridgeSize;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount() {
        Validation.isBiggerMove(moveCount, userBridgeSize);
        moveCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void moveUser(String bridge) {
        userLocation.add(bridge);
    }

    public List<String> getUserLocation() {
        return userLocation;
    }
}
