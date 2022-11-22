package bridge;

public class Application {

    public static void main(String[] args) {

        try {
            BridgeGameController bridgeGameController = new BridgeGameController();
            bridgeGameController.play();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
