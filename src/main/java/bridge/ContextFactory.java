package bridge;

public class ContextFactory {

    public BridgeNumberGenerator getBridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public RandomNumberHandler getRandomNumberHandler() {
        return new RandomNumberHandlerImpl();
    }

    public BridgeMaker getBridgeMaker() {
        return new BridgeMaker(getBridgeNumberGenerator());
    }

    public InputValidator getInputValidator() {
        return new InputValidatorImpl();
    }

    public InputView getInputView() {
        return new InputView(getInputValidator());
    }

    public OutputView getOutputView() {
        return new OutputView();
    }

    public BridgeGame getBridgeGame() {
        return new BridgeGame();
    }

    public BridgeGameStarter getBridgeGameStarter() {
        return new BridgeGameStarter(getBridgeMaker(), getInputView(), getOutputView(), getBridgeGame());
    }
}
