package bridge.controller;

import bridge.BridgeGame;
import bridge.model.BridgeSize;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeSize bridgeSize;
    private Player player;
    private String retryString;
    private String moveString;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        player = new Player();
        bridgeGame = new BridgeGame();
    }

    public void playGame() {

    }
}
