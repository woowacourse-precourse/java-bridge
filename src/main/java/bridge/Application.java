package bridge;

import bridge.contoller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        while(bridgeGameController.isContinued()){
            bridgeGameController.play();
        }
    }
}
