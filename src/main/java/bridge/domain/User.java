package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int countInputMoveDirection;
    private final List<String> moveDirectionSelection;

    public User() {
        countInputMoveDirection = 0;
        moveDirectionSelection = new ArrayList<>();
    }

    public void inputMoveDirection(String moveDirection) {
        moveDirectionSelection.add(moveDirection);
        countInputMoveDirection++;
    }

    public int getCountInputMoveDirection() {
        return countInputMoveDirection;
    }

    public String getMoveDirection() {
        return moveDirectionSelection.get(countInputMoveDirection - 1);
    }

    public int getMoveDirectionNumber() {
        return BridgeDirection.getDirectionNumber(getMoveDirection());
    }
}
