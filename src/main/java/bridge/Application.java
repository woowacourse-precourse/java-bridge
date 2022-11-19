package bridge;

import bridge.controller.GameController;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.model.Direction;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }
}
