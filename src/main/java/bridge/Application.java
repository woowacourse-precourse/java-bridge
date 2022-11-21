package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController controller = new BridgeGameController();
            controller.runBridgeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
