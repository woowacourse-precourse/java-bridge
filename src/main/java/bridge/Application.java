package bridge;

import bridge.controller.AppController;
import bridge.controller.BridgeGame;

public class Application {
    public static void main(String[] args) {
        AppController appController = new AppController();
        try {
            appController.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

