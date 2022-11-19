package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = BridgeGameController.init();
        controller.run();
    }
}
