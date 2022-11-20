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
        do {
            OutputView.askMove();
        } while (bridgeGame.move() && bridgeGame.isOnGoing());
        if (bridgeGame.isOnGoing()) {
            OutputView.askRestart();
            if (bridgeGame.retry()) {
                play();
                return;
            }
        }
        end();
    }

    private void end() {
    }
}
