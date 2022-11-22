package bridge;

import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            outputView.printStartMessage();
            int bridgeSize = inputView.readBridgeSize();
            BridgeGame bridgeGame = initialize(bridgeSize);
            printProgress(bridgeGame, bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private BridgeGame initialize(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        return bridgeGame;
    }

    private void printProgress(BridgeGame bridgeGame, int bridgeSize) {
        boolean isRetry = true;
        while(isRetry) {
            if(checkProgress(bridgeGame, bridgeSize)) {
                printSuccessFinalResult(bridgeGame);
                break;
            }
            isRetry = checkRetry(bridgeGame);
        }
    }

    private boolean checkProgress(BridgeGame bridgeGame, int bridgeSize) {
        int i = 0;
        while (i < bridgeSize) {
            if (!checkMoving(bridgeGame,i)) {
               return false;
            }
            i++;
        }
        return true;
    }

    private boolean checkMoving(BridgeGame bridgeGame, int i) {
        String moving = inputView.readMoving();
        boolean isSuccess = bridgeGame.move(i, moving);
        outputView.printMap(bridgeGame.getResults());
        return isSuccess;
    }

    private boolean checkRetry(BridgeGame bridgeGame) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            printFailFinalResult(bridgeGame);
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    private void printSuccessFinalResult(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame.getResults());
        outputView.printSuccess();
        outputView.printTotalTryCount(bridgeGame.getTryCount());
    }

    private void printFailFinalResult(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame.getResults());
        outputView.printFail();
        outputView.printTotalTryCount(bridgeGame.getTryCount());
    }
}
