package bridge;


public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new InputView(), new OutputView());
        runBridge(bridgeController);
    }

    private static void runBridge(BridgeController controller) {
        controller.start();
        BridgeBluePrint bluePrint = controller.drawBluePrint();
    }
}
