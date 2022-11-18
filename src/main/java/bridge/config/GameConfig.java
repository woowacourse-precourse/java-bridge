package bridge.config;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameConfig {
    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private BridgeNumberGenerator bridgeRandomNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeRandomNumberGenerator());
    }

    public GameController gameController() {
        return new GameController(bridgeMaker(), inputView(), outputView());
    }
}
