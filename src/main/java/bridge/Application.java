package bridge;

import util.InputValidator;
import util.InputView;
import util.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            InputValidator inputValidator = new InputValidator();
            InputView inputView = new InputView(inputValidator);
            OutputView outputView = new OutputView();
            BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView);
            bridgeGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
