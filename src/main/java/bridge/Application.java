package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator  bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        Controller controller = new Controller(inputView, outputView, bridgeRandomNumberGenerator);
        controller.startGame();
    }
}
