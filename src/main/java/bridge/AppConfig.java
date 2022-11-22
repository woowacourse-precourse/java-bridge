package bridge;

import bridge.controller.BridgeGame;
import bridge.controller.BridgeInputController;
import bridge.controller.BridgeMaker;
import bridge.view.InputView;

public class AppConfig {

    public GameManager gameManager(){

        return new GameManager(bridgeInputController(), bridgeMaker(), bridgeGame());
    }

    public BridgeGame bridgeGame() {
        return new BridgeGame();
    }

    public BridgeInputController bridgeInputController() {

        return new BridgeInputController(inputView());
    }

    public InputView inputView() {
        return new InputView(validationException());
    }

    public ValidationException validationException() {
        return new ValidationException();
    }

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
