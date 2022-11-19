package bridge.Service;

import bridge.game.BridgeGame;
import bridge.game.BridgeMaker;
import bridge.game.BridgeRandomNumberGenerator;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.validator.RetryType;

import java.util.List;

public class BridgeService {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startService() {
        try {
            initService();
            playService();
            printResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initService() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        bridgeGame.initGame(bridge);
    }

    private void playService() {
        boolean success = playBridgeGame();

        if (!success && checkRestart()) {
            bridgeGame.retry();
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
        return gameCommand.equals(RetryType.RETRY.getValue());
    }

    private void printResult() {
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getUserMoving(), bridgeGame.getAttemptCount());
    }
}
