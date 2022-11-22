package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        int gameSize = start();
        cycle(gameSize, true);
        end();
    }

    public void cycle(int gameSize, boolean isTry) {
        int correctStep = 0;

        while (gameSize != correctStep && isTry) {
            correctStep = move();
            if (!bridgeGame.isSuccess()) {
                isTry = askRetry();
            }
        }
    }

    private int start() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.start(bridgeSize);
        return bridgeSize;
    }

    private int move() {
        String direction = inputView.readMoving();
        int correctStep = bridgeGame.move(direction);
        outputView.printMap(bridgeGame.getGameResult());
        return correctStep;
    }


    private boolean askRetry() {
        String input = inputView.readGameCommand();
        return bridgeGame.retry(input);
    }

    private void end() {
        outputView.printResult(bridgeGame.getGameResult(), bridgeGame.isSuccess(), bridgeGame.getRetryCount());
    }
}
