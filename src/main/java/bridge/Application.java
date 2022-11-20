package bridge;


public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new InputView(), new OutputView());
        bridgeController.start();
        runBridge(bridgeController);
    }

    private static void runBridge(BridgeController controller) {
        BridgeBluePrint bluePrint = controller.getBridgeBluePrint();
    }
}
