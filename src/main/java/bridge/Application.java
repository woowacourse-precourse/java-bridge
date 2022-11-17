package bridge;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        try {
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
                outputView.printMap(bridgeGame);
                if (bridgeGame.aborted()) {
                    outputView.printRestart();
                    String cmd = inputView.readGameCommand();
                    bridgeGame.retry(cmd);
                }
            }
            outputView.printTotalMap(bridgeGame);
            outputView.printResult(bridgeGame.succeed(), bridgeGame.getTries());
        } catch (NoSuchElementException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
