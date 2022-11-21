package bridge;

import java.util.Deque;

public class GameWinChecker {

    public boolean isWin(Deque<MovementStatusForm> movementStatus, Integer bridgeSize){
        if(movementStatus.size() == bridgeSize){
            if(MovementStatusForm.isPassCase(movementStatus.getLast())){
                return true;
            }
        }
        return false;
    }

}
