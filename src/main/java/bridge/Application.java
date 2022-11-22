package bridge;

import bridge.Controller.Controller;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator  bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        try {
            Controller controller = new Controller(inputView, outputView, bridgeRandomNumberGenerator);
            controller.startGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
