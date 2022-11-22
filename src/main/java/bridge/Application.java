package bridge;

import bridge.controller.GameController;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try{
            GameController gameController = new GameController();
            gameController.StartGame();
            while(gameController.playEachGame()) {
                ;
            }
        } catch(Exception e){
            System.out.println("ERROR : " + e.getMessage());
        }

    }
}
