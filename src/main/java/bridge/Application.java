package bridge;

import bridge.controller.GameController;

public class Application {

    public static void main(String[] args) {
        try {
            GameController.run();
        } catch (Exception e) {
            Logger.log(e);
        }
    }
}
