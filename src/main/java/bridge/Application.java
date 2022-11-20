package bridge;

import bridge.controller.Controller;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Controller controller = new Controller();
            controller.run();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
