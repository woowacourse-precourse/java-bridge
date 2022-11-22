package bridge.domain;

import bridge.status.CountStatus;
import bridge.status.MoveResultStatus;
import bridge.status.PositionStatus;

import java.util.List;

public class User {
    private int count;
    private int tryCount;

    private final List<String> upSpace;

    private final List<String> downSpace;

    public User(List<String> upSpace, List<String> downSpace) {
        this.upSpace = upSpace;
        this.downSpace = downSpace;
        this.tryCount = CountStatus.INITIALIZE_TRY_COUNT.getNumber();
        this.count = CountStatus.INITIALIZE_COUNT.getNumber();
    }

    public void init() {
        upSpace.clear();
        downSpace.clear();
        count = CountStatus.INITIALIZE_COUNT.getNumber();
    }

    public void recordResult(String movingResult, String moving) {
        if (moving.equals(PositionStatus.UP.getText())) {
            upSpace.add(movingResult);
            downSpace.add(MoveResultStatus.NOTHING.getText());
            return;
        }
        downSpace.add(movingResult);
        upSpace.add(MoveResultStatus.NOTHING.getText());
    }

    public boolean sameBridgeSize(int size) {
        if (size == count) {
            return true;
        }
        return false;
    }

    public boolean lessThanBridgeSize(int size) {
        if (size > count) {
            return true;
        }
        return false;
    }

    public String movePosition(List<String> bridge, String userMoving) {
        if (bridge.get(count).equals(userMoving)) {
            recordResult(MoveResultStatus.CORRECT.getText(), userMoving);
            return MoveResultStatus.CORRECT.getText();
        }
        recordResult(MoveResultStatus.FAIL.getText(), userMoving);
        return MoveResultStatus.FAIL.getText();
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void increaseCount() {
        count++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getUpSpace() {
        return upSpace;
    }

    public List<String> getDownSpace() {
        return downSpace;
    }
}
