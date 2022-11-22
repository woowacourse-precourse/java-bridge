package bridge;

import bridge.service.GameManager;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
