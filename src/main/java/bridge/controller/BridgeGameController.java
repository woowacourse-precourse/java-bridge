package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private final Player player;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(BridgeGame bridgeGame, Player player) {
        this.bridgeGame = bridgeGame;
        this.player = player;
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        OutputView.start();
    }
}
