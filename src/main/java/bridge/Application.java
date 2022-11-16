package bridge;

import bridge.controller.BridgeGameController;

public class Application {
    private static final String ERROR = "[ERROR]";
    public static void main(String[] args) {
        BridgeGameController bridgeGameController = BridgeGameController.create();
        try{
            bridgeGameController.start();
        } catch (Exception e){
            System.out.println(ERROR + e.getMessage());
        }
    }
}
