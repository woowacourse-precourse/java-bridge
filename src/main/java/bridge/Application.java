package bridge;

import bridge.controller.Controller;
import bridge.view.InputView;

public class Application {
    public static void main(String[] args) {
            InputView inputView = new InputView();
            Controller controller = new Controller(inputView);

            controller.game();
    }
}
