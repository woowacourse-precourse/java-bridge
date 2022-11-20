package Controller;

import Model.Map;
import Util.Util;
import View.OutputView;
import java.util.List;

public class BridgeGame {
    OutputView outputView = new OutputView();
    Util util = new Util();

    public boolean move(Map map, List<String> crossable, int index) {
        boolean isWin;
        String moving;
        moving = util.determineWhereToGo();
        map.extendMap(index);
        isWin = map.runMap(moving, crossable.get(index));
        map.endMap();
        return isWin;
    }

    public boolean checkIfWin(List<String> crossable, Map map) {
        map.startMap();
        boolean returnValue = true;
        for (int index=0; index<crossable.size(); index++) {
            returnValue &= move(map, crossable, index);
            outputView.printMap(map.getMapUpper(), map.getMapLower());
        }
        return returnValue;
    }

    public boolean retry() {
        String continueOrEnd;
        continueOrEnd = util.determineIfContinue();
        return continueOrEnd.equals("R");
    }

    public boolean checkIfRetry(boolean isWin) {
        boolean isContinue = true;
        if (!isWin) {
            isContinue = retry();
        }
        if (isWin || !isContinue) {
            isContinue = false;
        }
        return isContinue;
    }

}



