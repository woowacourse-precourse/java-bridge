package bridge.service;

import bridge.type.ResultType;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame extends AbstractBridgeGame{
    public static int tryCnt = 1;


    public boolean move(List<String> bridgeInfo, String direction) {
        saveUserDirection(direction);
        bridgeDrawer.makePrintList(direction, bridgeInfo);
        drawMap();
        return checkService.checkCrossable(bridgeInfo, direction);
    }


    public boolean retry() {
        tryCnt ++;
        userDirection.clear();
        bridgeDrawer.initializeLists();
        return true;
    }

    public static void drawMap() {
        OutputView.printMap(bridgeDrawer.getDirectionTypeLists());
    }

    public static void drawFinalResult(ResultType resultType, int tryCnt) {
        OutputView.printMap(bridgeDrawer.getDirectionTypeLists());
        OutputView.printResult(resultType, tryCnt);
    }


    public void saveUserDirection(String direction) {
        userDirection.add(direction);
    }

    public static List<String> getUserDirection() {
        return userDirection;
    }

    public static int getUserDirectionSize() {
        return userDirection.size();
    }

    public static int getTryCnt() {
        return tryCnt;
    }
}
