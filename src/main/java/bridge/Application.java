package bridge;

import bridge.controller.Controller;
import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new BridgeGameService(), new InputView(), new OutputView());
        try {
            controller.start();
            controller.play();
            controller.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
