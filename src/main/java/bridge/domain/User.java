package bridge.domain;

import bridge.constant.GameConstant;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int countMove;
    private int trialCount;
    private final List<String> moveDirectionSelection;

    public User() {
        countMove = GameConstant.START_MOVE_COUNT;
        trialCount = GameConstant.START_TRY_COUNT;
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
        countMove = GameConstant.START_MOVE_COUNT;
        moveDirectionSelection.clear();
        trialCount++;
    }

    public int getTrialCount() {
        return trialCount;
    }
}
