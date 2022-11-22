package bridge;

import bridge.Controller.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.runGame();
    }
}
