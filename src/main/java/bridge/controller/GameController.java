package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final BridgeGame game;
    private final InputView inputView;
    private final OutputView outputView;

    private GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.game = new BridgeGame(this.inputView.readBridgeSize());
    }
    public static GameController start() {
        return new GameController();
    }

}
