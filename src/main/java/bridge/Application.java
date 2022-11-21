package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.runGame();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
