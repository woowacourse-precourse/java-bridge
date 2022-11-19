package bridge;

public class Application {

    public static void main(String[] args) {
        new BridgeGameProcessor(new InputView(new InputValidator()), new OutputView(), new BridgeMaker(new BridgeRandomNumberGenerator())).play();
    }
}
