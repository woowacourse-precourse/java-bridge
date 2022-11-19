package bridge;

import java.util.List;
import bridge.Map;
import bridge.Util;

public class BridgeGame {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
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

    public boolean play(List<String> crossable, Map map) {
        map.startMap();
        for (int index=0; index<crossable.size(); index++) {
            boolean isWin = move(map, crossable, index);
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
            return true;
        }
        return false;
    }

    public void controller() {
        int attempts = 1;
        int limitSize;
        boolean isContinue = true;
        boolean isWin;
        List<String> crossable;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        limitSize = util.determineBridgeSize();
        crossable = bridgeMaker.makeBridge(limitSize);
        Map map = new Map(crossable);

        while (isContinue) {
            isWin = play(crossable, map);
            if (!isWin) {
                isContinue = retry();
            }
            if (isWin||!isContinue) {
                    outputView.printTitle();
                    outputView.printMap(map.getMapUpper(),map.getMapLower());
                    outputView.printResult(isWin,attempts);
                    return;
                }
            attempts++;
            }
        }
    }

