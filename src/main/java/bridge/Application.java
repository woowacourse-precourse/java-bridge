package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        try {
           BridgeController bridgeController = new BridgeController();
           bridgeController.setGame();
           bridgeController.repeatGame();
           bridgeController.exitGame();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
