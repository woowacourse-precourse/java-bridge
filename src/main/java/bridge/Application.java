package bridge;

import bridge.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            GameController controller = new GameController();
            controller.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
