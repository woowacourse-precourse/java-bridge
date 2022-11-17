package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameManager manager = BridgeGameManager.gameManager();
        manager.play();
    }
}
