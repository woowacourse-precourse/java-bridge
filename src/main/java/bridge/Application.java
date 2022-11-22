package bridge;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.run();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("[ERROR] " + illegalArgumentException.getMessage());
        }
    }
}
