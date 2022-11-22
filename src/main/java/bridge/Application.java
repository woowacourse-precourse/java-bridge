package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController();
        bridgeController.start();
        bridgeController.enterBridgeSize();
        bridgeController.makeBridge();
        bridgeController.playGame();
        bridgeController.showResult();
    }
}
