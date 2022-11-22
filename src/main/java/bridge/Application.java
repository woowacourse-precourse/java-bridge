package bridge;


import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController controller = new BridgeController(new InputView(), new OutputView());
        run(controller);
    }

    private static void run(BridgeController controller) {
        boolean ready = true;
        while (ready) {
            ready = crossBridge(controller);
        }
        controller.exit();
    }

    private static boolean crossBridge(BridgeController controller) {
        controller.retry();
        boolean block = false;
        while (!block) {
            block = controller.move();
        }
        return controller.command();
    }
}
