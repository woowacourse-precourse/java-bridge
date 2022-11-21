package bridge;

import controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();

        try{
            bridgeController.makeBridge();
            bridgeController.startGame();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
