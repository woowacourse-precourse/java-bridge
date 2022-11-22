package bridge;

import bridge.Controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            GameController.getGameController();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
