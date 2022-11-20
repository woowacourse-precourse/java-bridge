package bridge;

import bridge.Controller.MainController;

public class Application {

    public static void main(String[] args) {
        MainController mainController = new MainController();
        try {
            mainController.initGame();
            mainController.run();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
