package bridge;

public class Application {
    public static void main(String[] args) {
        Controller bridgeController = new Controller();
        bridgeController.startController();
        bridgeController.setBridgeController();
        bridgeController.moveController();
    }
}
