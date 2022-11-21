package bridge;

public class Application {

    public static void main(String[] args) {
        InputValidation inputValidation = new InputValidation();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameUi bridgeGameUi = new BridgeGameUi(inputView, inputValidation, outputView);
        bridgeGameUi.run();
    }
}
