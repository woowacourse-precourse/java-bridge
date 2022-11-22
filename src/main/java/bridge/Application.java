package bridge;

import bridge.Constant.Constant;
import bridge.Controller.GameController;

public class Application {
    public static void main(String[] args) {
        System.out.println(Constant.Start_Game);
        try {
            GameController.setGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
