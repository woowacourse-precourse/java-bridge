package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    public static GameController instance = new GameController();

    public static GameController getInstance() {
        return instance;
    }

    private GameController() {}

    public BridgeGame create() {
        try {
            return new BridgeGame(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return create();
        }
    }

}
