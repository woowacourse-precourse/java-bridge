package bridge;

import bridge.Controller.Controller;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            Controller controller = new Controller();
            controller.run();
        } catch(IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
