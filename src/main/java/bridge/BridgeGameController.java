package bridge;

import bridge.enums.Number;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Result result = new Result();

    int index;
    boolean isCorrect;
    boolean isRetry;

    BridgeGameController() {
        index = Number.FIRST.getMessage();
        isRetry = false;
    }

    public void start() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        playGameSet(bridgeSize);
        outputView.printResult(result);
    }

    public void playGameSet(int bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        while (index < bridgeSize) {
            move(bridgeGame);
            chooseRetryOrQuit(bridgeGame);
            if(!isCorrect && !isRetry) {
                break;
            }
            index++;
        }
    }

    public void move(BridgeGame bridgeGame) {
        String inputMovingPosition = inputView.readMoving();
        isCorrect = bridgeGame.move(inputMovingPosition, index);
        result.addResult(inputMovingPosition, isCorrect);
        outputView.printMap(result);
    }

    public boolean chooseRetryOrQuit(BridgeGame bridgeGame) {
        if (!isCorrect) {
            isRetry = bridgeGame.retry(inputView.readGameCommand());
            quitSetUp();
            retrySetUp();
        }

        return isRetry;
    }

    public void quitSetUp() {
        if (!isRetry){
            result.setFail();
        }
    }

    public void retrySetUp() {
        result.addTryCount();
        result.removeLastResult();
        index--;
    }

}
