package bridge;

import bridge.controller.Controller;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new BridgeMaker(new BridgeRandomNumberGenerator()), new InputView(), new OutputView());
        controller.initialize();
        controller.start();
    }
}
