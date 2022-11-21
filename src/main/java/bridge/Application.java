package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
