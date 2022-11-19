package bridge;

import bridge.io.InputView;
import bridge.io.OutputView;

import java.util.List;

public class BridgeService {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startService() {
        initService();
        playService();
        printResult();
    }

    private void initService() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        bridgeGame.initGame(bridge);
    }

    private void playService() {
        boolean success = playBridgeGame();

        if (!success && checkRestart()) {
            playService();
        }
    }

    private boolean playBridgeGame() {
        boolean success = false;

        do {
            success = playOneTurn();
        } while (!isGameEnd(success));

        return success;
    }

    private boolean playOneTurn() {
        boolean success;

        String moving = inputView.readMoving();
        success = bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserMoving());

        return success;
    }

    private boolean isGameEnd(boolean success) {
        return !success || bridgeGame.isFinished();
    }

    private boolean checkRestart() {
        String gameCommand = inputView.readGameCommand();
        return bridgeGame.retry(gameCommand);
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getUserMoving(), bridgeGame.getAttemptCount());
    }
}
