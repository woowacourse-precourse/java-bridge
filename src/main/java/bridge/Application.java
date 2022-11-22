package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeController controller = new BridgeController();
        controller.makeBridgeByInput();
        controller.crossBridge();
        controller.showResult();
    }
}