package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;

    public BridgeController() {
        bridgeGame = makeSizedBridge();
    }

    public void run() {
        InputView.printStartMessage();
        playBridgeGame();
        OutputView.printResult(bridgeGame);
    }

    private void playBridgeGame() {
        do {
            playUntilFailure();
        } while (!bridgeGame.isReached() && retry());
    }

    private void playUntilFailure() {
        Player player = bridgeGame.getPlayer();
        do {
            move();
            OutputView.printMap(bridgeGame);
        } while (!bridgeGame.isReached() && player.getMoving());
    }

    private BridgeGame makeSizedBridge() {
        try {
            int size = InputView.readBridgeSize();
            return new BridgeGame(size);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return makeSizedBridge();
        }
    }

    private void move() {
        try {
            String moveCommand = InputView.readMoving();
            bridgeGame.move(moveCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            move();
        }
    }

    private boolean retry() {
        try {
            String gameCommand = InputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return retry();
        }
    }
}
