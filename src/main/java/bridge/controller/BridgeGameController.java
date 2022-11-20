package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGame;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void run() {
        OutputView.start();
        OutputView.askLength();
        bridgeGame.create();
        play();
    }

    private void play() {
        bridgeGame.tryGame();
        boolean isMoving = true;
        do {
            OutputView.askMove();
            isMoving = bridgeGame.move();
        } while (isMoving && bridgeGame.isOnGoing());
        if (!isMoving && bridgeGame.retry()) {
            play();
            return;
        }
        end();
    }

    private void end() {
    }
}
