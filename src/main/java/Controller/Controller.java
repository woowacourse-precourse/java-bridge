package Controller;

import Model.Map;
import Util.Util;
import View.OutputView;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Controller {

    private int attempts = 1;
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    Util util = new Util();
    List<String> crossable;
    int limitSize;
    Map map;

    public Controller() {
        this.limitSize = util.determineBridgeSize();
        this.crossable =bridgeMaker.makeBridge(limitSize);
        map = new Map(crossable);
    }

    public boolean play(int index) {
        boolean isWin = true;

        while (isWin&&index<limitSize) {
            isWin = bridgeGame.move(map, index++, util.determineWhereToGo());
            outputView.printMap(map.getMapUpper(), map.getMapLower());
        }

        return isWin;
    }

    public boolean isContinue(boolean isWin) {
        if (!isWin) {
            if(util.determineIfContinue()) {
                attempts = bridgeGame.retry(map,attempts);
                return true;
            }
        }
        return false;
    }

    public void controller(boolean isContinue) {
        boolean isWin = false;

        util.start(map);
        while (isContinue) {
            isWin = play(0);
            isContinue = isContinue(isWin);
        }
        outputView.printResult(map,isWin,attempts);
    }
}




