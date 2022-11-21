package bridge.domain.util;

import bridge.BridgeRandomNumberGenerator;
import bridge.controller.BridgeGameController;
import bridge.controller.InputController;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameManager;
import bridge.BridgeMaker;
import bridge.domain.UserBridge;
import bridge.domain.Validator;
import bridge.service.BridgeGameService;
import bridge.view.ErrorOutputView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppConfig {
    public BridgeGameController bridgeGameController() {
        return new BridgeGameController(bridgeGameService(), outputView(), inputController());
    }

    private InputController inputController() {
        return new InputController(inputView(), outputView(), errorOutputView());
    }

    private ErrorOutputView errorOutputView() {
        return new ErrorOutputView();
    }

    private BridgeGameService bridgeGameService() {
        return new BridgeGameService(bridgeGameManager(), bridgeGame(), userBridge(), bridgeMaker());
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeRandomNumberGenerator());
    }

    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager();
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame();
    }

    private UserBridge userBridge() {
        return new UserBridge();
    }

    private InputView inputView() {
        return new InputView(validator());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private Validator validator() {
        return new Validator();
    }
}
