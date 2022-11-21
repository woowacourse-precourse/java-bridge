package bridge;

import bridge.controller.GameManager;

public class Application {

    public static void main(String[] args) {
        try {
            GameManager gameManager = new GameManager();
            gameManager.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
