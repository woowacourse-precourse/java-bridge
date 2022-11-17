package bridge;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();

        outputView.printGameStart();
        bridgeGame.init();

        outputView.printReadBridgeLength();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.setBridgeSize(bridgeSize);

        while (!bridgeGame.isFinished()) {
            outputView.printReadNextBridgeStep();
            String moving = inputView.readMoving();

            bridgeGame.move(moving);
            outputView.printMap();
            if (bridgeGame.aborted()) {
                outputView.printRestart();
                String cmd = inputView.readGameCommand();
                bridgeGame.retry(cmd);
            }
        }

        outputView.printResult(bridgeGame.succeed(), bridgeGame.getTries());
    }
}
