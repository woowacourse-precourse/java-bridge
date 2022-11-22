package bridge;


import bridge.controller.BridgeGameController;

public class Application {
    private BridgeGameController bridgeGameController;

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.bridgeGame();
    }
}
