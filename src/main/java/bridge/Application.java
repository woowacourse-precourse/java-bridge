package bridge;

import bridge.controller.Controller;
import bridge.view.OutputView;

public class Application {
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printStartMessage();

        Controller controller = new Controller();
        controller.readyBridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));
    }
}
