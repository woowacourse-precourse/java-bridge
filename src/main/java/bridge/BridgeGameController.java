package bridge;

public class BridgeGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Result result = new Result();


    public void start() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        int index = 0;

        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        while (index < bridgeSize) {
            String inputMovingPosition = inputView.readMoving();
            boolean isCorrect = bridgeGame.move(inputMovingPosition, index);
            result.addResult(inputMovingPosition, isCorrect);
            outputView.printMap(result);

            if (!isCorrect) {
                if (bridgeGame.retry(inputView.readGameCommand())) {
                    result.addTryCount();
                    result.removeLastResult();
                    index--;
                } else {
                    result.setFail();
                    break;
                }
            }
            index++;
        }
        outputView.printResult(result);
    }
}
