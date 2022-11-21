package bridge.model;

import java.util.List;

public class GameJudge {
    private boolean gameSuccess = false;

    public boolean isOver(List<String> userSelectResult, List<String> computerBridge, boolean UnitSuccess) {
        if (userSelectResult.size() == computerBridge.size() && UnitSuccess) {
            gameSuccess = true;
        }// if
        return gameSuccess;
    }//isOver
}// end class
