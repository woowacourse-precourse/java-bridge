package bridge;

import bridge.gameController.GameController;

public class Application {

    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.run();

        }catch (Exception e){

        }
    }
}
