package bridge;

import bridge.controller.Controller;

public class Application {

    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.game();
        } catch (IllegalArgumentException ie) {
            System.out.println("[ERROR] " + ie.getMessage());
        }
    }
}
