package bridge.controller;

import bridge.service.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run() {
        int gameSize = start();
        cycle(gameSize, true);
        end();
    }

    public void cycle(int gameSize, boolean isRetry) {
        int challengeStep = 0;

        while (gameSize != challengeStep && isRetry) {
            challengeStep = move();
            if (!bridgeGame.isSuccess()) {
                isRetry = askRetry();
            }
        }
    }

    private int start() {
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame.start(bridgeMaker.makeBridge(bridgeSize));
        return bridgeSize;
    }

    private int move() {
        String direction = inputView.readMoving();
        int bridgeStep = bridgeGame.move(direction);
        outputView.printMap(bridgeGame.getGameResult());
        return bridgeStep;
    }

    private boolean askRetry() {
        String input = inputView.readGameCommand();
        return bridgeGame.retry(input);
    }

    private void end() {
        outputView.printResult(bridgeGame.getGameResult(), bridgeGame.isSuccess(), bridgeGame.getRetryCount());
    }
}
