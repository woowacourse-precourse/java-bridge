package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController controller = new BridgeGameController();
        controller.startNewGame();
        controller.playGame();
    }
}
