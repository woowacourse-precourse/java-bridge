package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final static int START_MOVE_COUNT = 0;
    private final static int START_TRY_COUNT = 1;

    private int countMove;
    private int trialCount;
    private final List<String> moveDirectionSelection;

    public User() {
        countMove = START_MOVE_COUNT;
        trialCount = START_TRY_COUNT;
        moveDirectionSelection = new ArrayList<>();
    }

    public void inputMoveDirection(String moveDirection) {
        moveDirectionSelection.add(moveDirection);
        countMove++;
    }

    public int getCountInputMoveDirection() {
        return countMove;
    }

    public String getMoveDirection() {
        return moveDirectionSelection.get(countMove - 1);
    }

    public int getMoveDirectionNumber() {
        return BridgeDirection.getDirectionNumber(getMoveDirection());
    }

    public void retry() {
        countMove = START_MOVE_COUNT;
        moveDirectionSelection.clear();
        trialCount++;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
