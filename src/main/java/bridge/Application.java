package bridge;

import bridge.controller.GameController;
import bridge.model.BridgeGame;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.start();
        }catch (IllegalArgumentException e){
            OutputView.printError(e.getMessage());
        }
    }
}
