package bridge;

import controller.Controller;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new OutputView(), new InputView());
        controller.startGame(new BridgeGame());
    }
}