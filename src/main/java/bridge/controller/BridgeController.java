package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final Player player;

    public BridgeController() {
        bridgeGame = makeSizedBridge();
        player = bridgeGame.getPlayer();
    }

    public void run() {
        InputView.printStartMessage();
        playBridgeGame(player);
        OutputView.printResult(bridgeGame);
    }

    private void playBridgeGame(Player player) {
        do {
            playUntilFailure(player);
        } while (!bridgeGame.isReached() && retry());
    }

    private void playUntilFailure(Player player) {
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

    private boolean move() {
        try {
            String moveCommand = InputView.readMoving();
            return bridgeGame.move(moveCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return move();
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
