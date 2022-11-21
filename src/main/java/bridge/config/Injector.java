package bridge.config;

import bridge.controller.BridgeGameController;
import bridge.service.BridgeService;
import bridge.view.GameView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Injector {
    public static GameView getGameView() {
        BridgeGameController bridgeGameController = new BridgeGameController(new BridgeService());
        InputView inputView = new InputView(bridgeGameController);
        OutputView outputView = new OutputView(bridgeGameController);
        return new GameView(inputView, outputView);
    }
}
