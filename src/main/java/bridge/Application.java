package bridge;

import bridge.Controller.Controller;

public class Application {

    public static void main(String[] args) {
        try{
            Controller controller = new Controller();
            controller.run();
        } catch(IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        } catch(Exception e){
            System.out.println("[ERROR] 예상치 못한 예외입니다.");
        }
    }
}
