package bridge;

import bridge.Controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.playGame();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
