package bridge;

import java.util.Deque;

public class GameOverChecker {

    public boolean isOver(Deque<MovementStatusForm> movementStatus, Integer bridgeSize) {
        if (movementStatus.size() != bridgeSize) {
            if (MovementStatusForm.isPassCase(movementStatus.getLast())) {
                return false;
            }
        }
        return true;
    }

}
