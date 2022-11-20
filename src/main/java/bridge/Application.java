package bridge;

import bridge.controller.GameController;
import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.gameStart();
    }
}
