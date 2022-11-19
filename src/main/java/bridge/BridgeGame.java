package bridge;

import java.util.List;
import bridge.Map;

public class BridgeGame {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public int determineBridgeSize() {
        outputView.printBridgeLengthInputRequest();
        return inputView.readBridgeSize();
    }
/*
    public int move(List<String> crossable) {
        int howManyAttempts;
        howManyAttempts = bridgeMaker.makeMap(crossable);
        return howManyAttempts;
    }
*/
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
        limitSize = determineBridgeSize();
        crossable = bridgeMaker.makeBridge(limitSize);
        Map map = new Map(crossable);

        while (!endGame) {
            isWin = map.makeMap(crossable);
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

