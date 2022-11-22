package bridge;

import bridge.game.GameManager;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        gameManager.game();
    }
}
