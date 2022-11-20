package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Player;
import bridge.view.InputView;
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
        boolean isMoving;
        do {
            OutputView.askMove();
            isMoving = bridgeGame.move();
        } while (isMoving);
    }
}
