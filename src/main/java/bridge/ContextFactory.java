package bridge;

import bridge.util.inputvalidator.InputValidator;
import bridge.util.inputvalidator.InputValidatorImpl;
import bridge.util.numbergenerator.BridgeNumberGenerator;
import bridge.util.numbergenerator.BridgeRandomNumberGenerator;
import bridge.util.numberhandler.RandomNumberHandler;
import bridge.util.numberhandler.RandomNumberHandlerImpl;

public class ContextFactory {

    public BridgeNumberGenerator getBridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public RandomNumberHandler getRandomNumberHandler() {
        return new RandomNumberHandlerImpl();
    }

    public InputValidator getInputValidator() {
        return new InputValidatorImpl();
    }

    public BridgeMaker getBridgeMaker() {
        return new BridgeMaker(getBridgeNumberGenerator(), getRandomNumberHandler());
    }
    public InputView getInputView() {
        return new InputView(getInputValidator());
    }

    public OutputView getOutputView() {
        return new OutputView();
    }

    public BridgeGameStarter getBridgeGameStarter() {
        return new BridgeGameStarter(getInputView(), getOutputView(), getBridgeMaker(), getBridgeGame());
    }
    public BridgeGame getBridgeGame() {
        return new BridgeGame();
    }
}
