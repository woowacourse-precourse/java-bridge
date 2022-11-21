package bridge.model;

import java.util.List;

public class GameJudge {

    public boolean isOver(List<String> userSelectResult, List<String> computerBridge, boolean UnitSuccess) {
        boolean gameSuccess = false;
        if (userSelectResult.size() == computerBridge.size() && UnitSuccess) {
            gameSuccess = true;
        }// if
        return gameSuccess;
    }//isOver
}// end class
