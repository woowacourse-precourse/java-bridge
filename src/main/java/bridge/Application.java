package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = BridgeController.start();
        boolean alive;
        boolean restart;

        do {
            alive = bridgeController.play();
            restart = bridgeController.restart(alive);
        } while (restart);
        bridgeController.finish(alive);
    }
}
