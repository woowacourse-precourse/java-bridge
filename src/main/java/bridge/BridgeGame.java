package bridge;

import java.util.List;

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
            return true;
        }
        return false;
    }

    public boolean play(int limitSize, BridgeMaker bridgeMaker) {
        boolean isWin;
        List<String> crossable;

        crossable = bridgeMaker.makeBridge(limitSize);
        isWin = bridgeMaker.makeMap(crossable);

        return isWin;
    }

    public void controller() {
        int attempts = 1;
        int limitSize;
        String gameCommand;
        boolean endGame = false;
        boolean isWin;

        limitSize = determineBridgeSize();

        while (!endGame) {
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            isWin = play(limitSize, bridgeMaker);
            if (isWin) {
                outputView.printTitle();
                outputView.printMap(bridgeMaker.getMapUpper(),bridgeMaker.getMapLower());
                outputView.printResult(isWin,attempts);
                endGame = true;

            }
            if (!isWin) {
                outputView.printContinueOrEndRequest();
                gameCommand = inputView.readGameCommand();
                if (gameCommand.equals("R")) {
                    attempts++;
                    continue;
                } else {
                    outputView.printTitle();
                    outputView.printMap(bridgeMaker.getMapUpper(),bridgeMaker.getMapLower());
                    outputView.printResult(isWin,attempts);
                    endGame = true;
                }
            }
        }
    }
}
