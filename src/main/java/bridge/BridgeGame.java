package bridge;

import java.util.List;
import bridge.Map;
import bridge.Util;

public class BridgeGame {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Util util = new Util();

    public boolean move(List<String> crossable, Map map) {
        boolean isWin;
        String moving;
        int index = 0;
        map.resetMap();
        map.startMap();
        while (map.mapIndexOutOfRange(index)) {
            moving = util.determineWhereToGo();
            map.extendMap(index);
            isWin = map.runMap(moving, crossable.get(index));
            map.endMap();
            index++;
            outputView.printMap(map.getMapUpper(), map.getMapLower());
            if (!isWin) {
                return false;
            }
        }
        return true;
    }

    public boolean retry() {
        String continueOrEnd;
        outputView.printContinueOrEndRequest();
        continueOrEnd = inputView.readGameCommand();
        if (continueOrEnd.equals("R")) {
            return false;
        }
        return true;
    }

    public void controller() {
        int attempts = 1;
        int limitSize;
        boolean endGame = false;
        boolean isWin;
        List<String> crossable;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        limitSize = util.determineBridgeSize();
        crossable = bridgeMaker.makeBridge(limitSize);
        Map map = new Map(crossable);

        while (!endGame) {
            isWin = move(crossable, map);
            if (!isWin) {
                endGame = retry();
            }
            if (isWin||endGame) {
                    outputView.printTitle();
                    outputView.printMap(map.getMapUpper(),map.getMapLower());
                    outputView.printResult(isWin,attempts);
                    return;
                }
            attempts++;
            }
        }
    }

