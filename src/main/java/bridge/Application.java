package bridge;

import bridge.controller.Controller;
import bridge.view.InputView;

public class Application {
    public static void main(String[] args) {
            Controller controller = new Controller();

            controller.game();
    }
}
