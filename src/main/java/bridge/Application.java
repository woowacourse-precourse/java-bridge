package bridge;


public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new InputView(), new OutputView());
        bridgeController.start();
        crossBridge(bridgeController);
    }

    private static void crossBridge(BridgeController controller) {
        BridgeBluePrint bluePrint = controller.makeBridgeBluePrint();
        while (controller.isReady()) {
            move(controller);
        }
    }

     private static void move(BridgeController controller) {
        boolean done = false;
        while (!done) {

        }
    }
}
