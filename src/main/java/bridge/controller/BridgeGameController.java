package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private final Player player;

    public BridgeGameController(BridgeGame bridgeGame, Player player) {
        this.bridgeGame = bridgeGame;
        this.player = player;
    }

    public void run() {
        OutputView.start();
        OutputView.askLength();
    }
}
